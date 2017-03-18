/**
 * 
 */
package com.xinxilanr.venus.web.forms.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.xinxilanr.venus.web.forms.RegisterForm;

/**
 * @author norris
 *
 */
@Component
public class RegisterFormValidator implements Validator {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(RegisterFormValidator.class);
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegisterForm.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		RegisterForm form = (RegisterForm)target;
		if (! form.getPassword().equals(form.getPasswordRepeat())) {
			errors.rejectValue("passwordRepeat", "error.register.pwddiff");
		}
	}

}
