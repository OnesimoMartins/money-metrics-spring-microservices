package ao.accountservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.accountservice.api.dto.RequestUtils;
import ao.accountservice.api.dto.request.ExpenseInput;
import ao.accountservice.api.dto.request.IncomeInput;
import ao.accountservice.api.dto.response.SavingResponse;
import ao.accountservice.api.proxy.CurrencyApiProxy;
import ao.accountservice.domain.model.Saving;
import ao.accountservice.domain.service.AccountSavingService;
import ao.accountservice.domain.service.SavingService;

@RequestMapping("account/{id}")
@RestController
public class AccountSavingsController {

	@Autowired
	private AccountSavingService accountSavingService;
	@Autowired
	private SavingService savingService;
	@Autowired
	private CurrencyApiProxy currencyApi;

	@PutMapping("/income")
	public void income(@RequestBody @Valid IncomeInput incomeInput, @PathVariable("id") Long accountId) {
		accountSavingService.addIncome(accountId, RequestUtils.convertToIncome(incomeInput));
	}

	@PutMapping("/expense")
	public void expense(@RequestBody @Valid ExpenseInput expenseInput, @PathVariable("id") Long accountId) {
//		System.out.println(expenseInput.toString() + "---" + accountId);
		accountSavingService.addExpense(RequestUtils.convertToExpense(expenseInput, accountId));
	}


	@PutMapping("/convert-saving/{savingId}/to/{to}")
	public SavingResponse convertSaving(@PathVariable String to, @PathVariable Long savingId) {

		var saving = savingService.getSavingById(savingId);
		System.out.println(saving.toString());

		var convertedCurrency = currencyApi.convert(saving.getCurrencyCode(), to, saving.getAmount());

		System.out.println(convertedCurrency.toString());

		var convertedSaving = accountSavingService.convertSavingCurrency(savingId, convertedCurrency.getTo().getId(),
				convertedCurrency.getTotalCalculatedAmount());

		System.out.println(convertedSaving.toString());

		return SavingResponse.builder().id(convertedSaving.getId()).calculatedAmount(convertedSaving.getAmount())
				.currencyCode(convertedSaving.getCurrencyCode()).name(convertedSaving.getName()).build();
	}

	@GetMapping("/savings/{savingId}")
	public Saving haveSaving(@PathVariable Long savingId) {
		return savingService.getSavingById(savingId);
	}

//
//	@PutMapping("transfer/to/{anotherAnotherAccount}")
//	public void TransferMoneyToAnotherSaving() {
//	}

}
