package ao.accountservice.domain.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.accountservice.domain.model.Expense;
import ao.accountservice.domain.model.Income;
import ao.accountservice.domain.model.Saving;
import ao.accountservice.domain.repository.ExpenseRepository;
import ao.accountservice.domain.repository.IncomeRepository;

@Service
public class AccountSavingService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private IncomeRepository incomes;

	@Autowired
	private SavingService savingService;

	@Autowired
	private ExpenseRepository expenses;

	@Transactional
	public void addIncome(Long accountId, Income income) {

		var account = this.accountService.getAccountById(accountId);
		income.setAccountId(account.getUsername());

		savingService.getSavingById(income.getSavingId()).addAmount(income.getAmount());

		incomes.save(income);
	}

	@Transactional
	public void addExpense(Expense expense) {
		// check if the account exists
		accountService.getAccountById(expense.getAccountId());

		var availableAmmount = savingService.getSavingById(expense.getAccountId()).getAmount();

		availableAmmount.subtract(expense.getAmount());
		expenses.save(expense);
	}

	@Transactional
	public Saving convertSavingCurrency(Long savingId, String to, BigDecimal newAmount) {
		var saving = savingService.getSavingById(savingId);
		saving.setCurrencyCode(to);
		saving.setAmount(newAmount);
		return saving;
	}

}
