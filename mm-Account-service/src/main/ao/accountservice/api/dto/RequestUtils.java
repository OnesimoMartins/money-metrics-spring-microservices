package ao.accountservice.api.dto;

import ao.accountservice.api.dto.request.AccountInput;
import ao.accountservice.api.dto.request.ExpenseInput;
import ao.accountservice.api.dto.request.IncomeInput;
import ao.accountservice.domain.model.Account;
import ao.accountservice.domain.model.Expense;
import ao.accountservice.domain.model.Income;

public abstract class RequestUtils {

	public static Income convertToIncome(IncomeInput input) {
		var income = new Income();

		income.setAmount(input.getAmount());
		income.setSavingId(input.getSavingId());
		income.setDescription(input.getDescription());
		return income;
	}

	public static Expense convertToExpense(ExpenseInput input,Long accountId) {
		var expense = new Expense();
		
		expense.setAccountId(accountId);
		expense.setAmount(input.getAmount());
		expense.setSavingId(input.getSavingId());
		expense.setDescription(input.getDescription());
		
		return expense;
	}

	public static Account ConvertToAccount(AccountInput accountInput) {
		var account = new Account(accountInput.getFirstName(), accountInput.getLastName(), accountInput.getUsername(),
				accountInput.getPassword());
		return account;
	}
}
