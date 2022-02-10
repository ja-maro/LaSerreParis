package fr.eql.ai110.laserre.ibusiness.roles;

import fr.eql.ai110.laserre.entity.User;

public interface AccountIBusiness {
	
	static final int SALT_LENGTH = 4;
	static final String HASH_ALGORITHM = "SHA-256";
	static final int VALIDATION_CODE_LENGTH = 6;

	/**
	 * registers new user in database after salting and hashing 
	 * their password and creating their email validation code
	 * @param user all given information for new user, excluding password
	 * @param password not hashed password
	 */
	User register(User user, String password);
	
	/**
	 * Tries to authenticate user from given email and password
	 * @return authentified user
	 */
	User connect(String email, String password);
}
