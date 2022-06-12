package ao.accountservice.core.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ao.accountservice.api.dto.request.ExpenseInput;
import ao.accountservice.domain.service.SavingService;

public class HasEnoughMoneyOnSavingValidation
		implements ConstraintValidator<HasEnoughMoneyOnSaving, ExpenseInput> {

	@Autowired private SavingService savingService;
	
	@Override
	public boolean isValid(ExpenseInput expense, ConstraintValidatorContext context) {
		var availableAmmount=savingService.getSavingById(expense.getSavingId()).getAmount();
		var isEnough =availableAmmount.subtract(expense.getAmount()).compareTo(BigDecimal.ZERO)!=-1;
		return isEnough;//;
	}

}
