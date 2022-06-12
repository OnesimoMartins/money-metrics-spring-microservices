package ao.statservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ao.statservice.domain.model.dto.AccountSavingsDto;
import ao.statservice.domain.model.dto.ExpenseDto;
import ao.statservice.domain.model.dto.IncomeDto;
import ao.statservice.domain.model.dto.SavingDto;
import ao.statservice.domain.service.StatsService;

@RestController
@RequestMapping("stats/account/{id}")
public class AccountStatsController {

	@Autowired
	private StatsService statService;

	@GetMapping("/top-savings")
	public List<SavingDto> getAccountTopSavings( @RequestParam(required = false) Integer top) {
		return statService.getTopSavings(top!=null?top:5);
	}

	@GetMapping("/highest-expenses")
	public List<ExpenseDto> expenseStats(@RequestParam Integer top) {
		return statService.getTopExpenses(top!=null?top:5);
	}

	@GetMapping("/highest-incomes")
	public List<IncomeDto> incomeStats( @RequestParam(required = false) Integer top) {
		return statService.getTopIncomes(top!=null?top:10);
	}

//	// percentagem do seu dinheiro referente as diversas economias
	@GetMapping("/money-percentage") // param currency
	public AccountSavingsDto moneyDistributionPercentage(@PathVariable Long id) {
		return statService.getMoneyPercentage(id);
	}

}
