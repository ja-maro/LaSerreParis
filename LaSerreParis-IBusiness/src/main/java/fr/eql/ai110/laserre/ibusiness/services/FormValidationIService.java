package fr.eql.ai110.laserre.ibusiness.services;

import java.time.LocalDate;

public interface FormValidationIService {

	/**
	 * CHecks the database to see if a user with the given email already exists.
	 * 
	 * @param email email to check against the database
	 * @return true if the given email is not used
	 */
	boolean isEmailAvailable(String email);
	boolean isEmailSyntaxValid (String email);
	boolean isPhoneSyntaxValid(String phone);
	boolean isNameSyntaxValid(String name);
	/**
	 * Allows validation of given password by checking if it is secure enough.
	 * 
	 * @param password password to check
	 * @return true if password is secure enough
	 */
	boolean isPasswordSyntaxvalid(String password);
	/**
	 * Allows validation of given birth date by checking on the user's current age.
	 * 
	 * @param birthDate birth date to check
	 * @return true if user is not a minor and if age is not excessive
	 */
	boolean isBirthDateValid(LocalDate birthDate);
	/**
	 * Allows validation of given text message body by checking on its length.
	 * 
	 * @param text message to check
	 * @return true if not empty or too short
	 */
	boolean isMessageValid(String text);
	
	
}
