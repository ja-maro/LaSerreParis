package fr.eql.ai110.laserre.business.services;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai110.laserre.ibusiness.services.FormValidationIService;

@Remote(FormValidationIService.class)
@Stateless
public class FormValidationService implements FormValidationIService {
	
	private static final long MAJORITY_AGE = 18;
	private static final long MAX_AGE = 150;

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
		String regex = "^((\\+|00)33|0)\\s*[1-9]([\\s.-]*\\d{2}){4}$";
		return regexValidator(regex, phone);
	}

	@Override
	public boolean isNameSyntaxValid(String name) {
		String regex = "^([^\\.%*_\"#\\&@\\{\\(\\[\\|\\]\\)\\}=\\+\\/\\\\°!:;,?µ§£$¤¨^\\d])+$";
		return regexValidator(regex, name);
	}

	@Override
	public boolean isPasswordSyntaxvalid(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?\\/*~$^+=<>]).{6,}$";
		return regexValidator(regex, password);
	}

	@Override
	public boolean isBirthDateValid(LocalDate birthDate) {
		boolean isValid = false;
		if(LocalDate.now().minusYears(MAJORITY_AGE).isAfter(birthDate) && 
				LocalDate.now().minusYears(MAX_AGE).isBefore(birthDate)) {
			isValid = true;
		}
		return isValid;
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
