package fr.eql.ai110.laserre.business.roles;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.entity.User;
import fr.eql.ai110.laserre.ibusiness.roles.AccountIBusiness;
import fr.eql.ai110.laserre.idao.UserIDAO;

@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {

	@EJB
	private UserIDAO userDAO;
	
	@Override
	public User register(User user, String password) {
		String salt = alphanumericGenerator(SALT_LENGTH);
		user.setSalt(salt);
		user.setPassword(hashPassword(salt, password));
		user.setValidationCode(alphanumericGenerator(VALIDATION_CODE_LENGTH));
		userDAO.add(user);
		return user;
	}

	/**
	 * Allows secure storage of passwords in database thanks to 
	 * salting and hashing
	 * @param salt
	 * @param password
	 * @return
	 */
	private String hashPassword(String salt, String password) {
		String saltedPassword = salt + password;
		String HashedPassword = null;
		try {
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			byte[] encodedHash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
			HashedPassword = new String (encodedHash, StandardCharsets.UTF_8);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return HashedPassword;
	}

	/**
	 * Generates a random alphanumeric String
	 * @param length Length of generated String
	 * @return
	 */
	private String alphanumericGenerator(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(alphanumeric.length());
			char randomChar = alphanumeric.charAt(randomIndex);
			sb.append(randomChar);
		}
		return sb.toString();
	}

	@Override
	public User connect(String email, String password) {
		String salt = userDAO.getSalt(email);
		String hashedPassword = hashPassword(salt, password);

		return userDAO.authenticate(email, hashedPassword);
	}

}
