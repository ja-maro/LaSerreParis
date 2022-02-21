package fr.eql.ai110.laserre.business.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormValidationServiceTest {

	private FormValidationService validator;

	@BeforeEach
	public void beforeEach()
	{
		validator = new FormValidationService();
	}
	
	@Test
	public void emailsyntax_whenNoArobase_isIncorrect() {
		assertFalse(validator.isEmailSyntaxValid("aaaaa.aaa.aa"));
	}
	@Test
	public void emailsyntax_whenValid_IsCorrect() {
		assertTrue(validator.isEmailSyntaxValid("aaaaa.aaa@aa.aa"));
	}
	@Test
	public void emailsyntax_whenValid_IsCorrect2() {
		assertTrue(validator.isEmailSyntaxValid("jean.mar@gmail.com"));
	}
	
	@Test
	public void phoneSyntax_whenTooShort_isIncorrect() {
		assertFalse(validator.isPhoneSyntaxValid("05010203"));
	}
	@Test
	public void phoneSyntax_whenValid_IsCorrect() {
		assertTrue(validator.isPhoneSyntaxValid("0680959285"));
	}
	@Test
	public void phoneSyntax_whenValid_IsCorrect2() {
		assertTrue(validator.isPhoneSyntaxValid("+33 689524896"));
	}

}
