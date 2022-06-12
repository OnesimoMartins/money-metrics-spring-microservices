package ao.accountservice.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ao.accountservice.domain.repository.AccountRepository;

public class UsernameNotUsedValidation implements ConstraintValidator<UsernameNotUsed, String> {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
			return accountRepository.findAccounttByUsername(value)==null;
	}

}
