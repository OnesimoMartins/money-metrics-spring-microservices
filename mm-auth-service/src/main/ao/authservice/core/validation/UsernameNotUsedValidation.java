package ao.authservice.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ao.authservice.domain.service.AccountService;

public class UsernameNotUsedValidation implements ConstraintValidator<UsernameNotUsed, String> {

	@Autowired
	private AccountService accountService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
         return !accountService.checkUsername(value);	
         
	}

}
