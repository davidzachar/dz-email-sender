package com.email.sender.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

public class CommaSeparetedEmailsValidator implements ConstraintValidator<CommaSeparatedEmails, CharSequence> {
	
	EmailValidator emailValidator = new EmailValidator();
	
	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if ( value == null || value.length() == 0 ) {
			return true;
		}
		
		if (value.equals(",")) {
			return false;
		}
		
		String stringValue = value.toString();
		if (stringValue.contains(",,")) {
			return false;
		}
		
		if (stringValue.contains(",")) {
			String[] emails = stringValue.split(",");
			if (emails.length == 0)
				return false;
			boolean result = true;
			for (String email : emails) {
				result = result && !email.trim().isEmpty() && emailValidator.isValid(email.trim(), context);
			}
			return result;
		} else {
			return emailValidator.isValid(stringValue.trim(), context);
		}
	}

}
