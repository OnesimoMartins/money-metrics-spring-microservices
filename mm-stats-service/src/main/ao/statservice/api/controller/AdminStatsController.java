package ao.statservice.api.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ao.statservice.domain.filter.TimeFilter;
import ao.statservice.domain.model.dto.AmountDto;
import ao.statservice.domain.model.dto.DiaryExpensesDto;
import ao.statservice.domain.model.dto.DiaryIncomesDto;
import ao.statservice.domain.model.dto.SavingDto;
import ao.statservice.infrastructure.AdminStatsQueryImpl;

@RestController
@RequestMapping("/stats/admin")
public class AdminStatsController {

	//@Autowired private StatsService statService;
	
	@Autowired private AdminStatsQueryImpl statService;
	
	@GetMapping("/diary-incomes")
	public List<DiaryIncomesDto> getIncomesStats(TimeFilter filter){//TimeFilter filter
		statService.getDiaryIncomes(new TimeFilter(null, null));
		return null;	
	}
	
	@GetMapping("/diary-expenses")
	public List<DiaryExpensesDto> getExpenseStats(TimeFilter filter) {
		return statService.getDiaryExpense(filter);
	}
	
	@GetMapping("/top-savings")
	public List<SavingDto> getTopSavings(@RequestParam(required = false) Integer top) {
		return statService.getTopSavings(top);	
	}

	@GetMapping("/top-currencies")
	@PostConstruct
	//@RequestParam(required = false) Integer top
	public List<AmountDto> getTopCurrencies() {
		statService.getTopCurrencies(2).forEach(System.out::println);
		return null ;	
	}

}
