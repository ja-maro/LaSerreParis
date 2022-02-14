package fr.eql.ai110.laserre.idao;

import fr.eql.ai110.laserre.entity.User;

public interface UserIDAO extends GenericIDAO<User>{

	/**
	 * Retrieves salt of corresponding user to allow authentication
	 * @param email unique email of the user
	 * @return salt of user
	 */
	String getSalt(String email);
	
	/**
	 * Authentifies user if given email and password are valid
	 * @param email
	 * @param hashedPassword salted and hashed password
	 * @return authentified user
	 */
	User authenticate(String email, String hashedPassword);
	
	/**
	 * Searches for user with given email in database
	 * 
	 * @param email 
	 * @return User with given email
	 */
	User getByEmail(String email);

}
