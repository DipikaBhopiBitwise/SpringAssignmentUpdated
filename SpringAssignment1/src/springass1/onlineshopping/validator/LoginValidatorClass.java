package springass1.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springass1.onlineshopping.model.UserDetailsClass;


public class LoginValidatorClass implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return UserDetailsClass.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username","UserName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password","Password Required");
	}

	

	

	
	
	

}
