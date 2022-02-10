package fr.eql.ai110.laserre.business.services;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidationService implements fr.eql.ai110.laserre.ibusiness.services.FormValidationService {

	@Override
	public boolean isEmailSyntaxValid(String email) {
		String regex = "[^@]+@[^@]+\\.[^@.]+";
		return regexValidator(regex, email);
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(email);
//		return matcher.matches();
	}

	@Override
	public boolean isPhoneSyntaxValid(String phone) {
		String regex = ".";
		return regexValidator(regex, phone);
	}

	@Override
	public boolean isNameSyntaxValid(String name) {
		String regex = "^([^\\.%*_\"#\\&@\\{\\(\\[\\|\\]\\)\\}=\\+\\/\\\\°!:;,?µ§£$¤¨^])+$";
		return regexValidator(regex, name);
	}

	@Override
	public boolean isPasswordSyntaxvalid(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
		return regexValidator(regex, password);
	}

	@Override
	public boolean isBirthDateValid(LocalDate birthDate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks if the String matches the given Regular Expression Pattern
	 * 
	 * @param regex String of Regular Expression pattern
	 * @param toCheck String to check against the regex pattern
	 * @return true if matches
	 */
	private boolean regexValidator(String regex, String toCheck) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(toCheck);
		return matcher.matches();
	}
	
	
}
