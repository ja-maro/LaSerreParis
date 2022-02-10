package fr.eql.ai110.laserre.ibusiness.services;

import java.time.LocalDate;

public interface FormValidationService {

	boolean isEmailSyntaxValid (String email);
	boolean isPhoneSyntaxValid(String phone);
	boolean isNameSyntaxValid(String name);
	boolean isPasswordSyntaxvalid(String password);
	boolean isBirthDateValid(LocalDate birthDate);
	
}
