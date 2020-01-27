package com.email.sender.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CommaSeparetedEmailsValidatorTest {

	CommaSeparetedEmailsValidator validator = new CommaSeparetedEmailsValidator();
	
	@Mock
	ConstraintValidatorContext context;
	
	@Test
	public void testEdgeCases() {
		assertTrue(validator.isValid(null, context));
		assertTrue(validator.isValid("", context));
		
		assertFalse(validator.isValid(",", context));
		assertFalse(validator.isValid(",,", context));
		assertFalse(validator.isValid(" , , ", context));
		assertFalse(validator.isValid(",,,", context));
		assertFalse(validator.isValid("email@gmail.com,,", context));
		assertFalse(validator.isValid("email@gmail.com, , ", context));
		assertFalse(validator.isValid("email1@gmail.com,email2@gmail.com,,", context));
	}
	
	@Test
	public void testNormalData() {
		 assertTrue(validator.isValid("email@gmail.com", context));
		 assertTrue(validator.isValid("email@gmail.com,email2@gmail.com,email3@gmail.com", context));
		 assertTrue(validator.isValid("email@gmail.com, email2@gmail.com , email3@gmail.com", context));
	}
}
