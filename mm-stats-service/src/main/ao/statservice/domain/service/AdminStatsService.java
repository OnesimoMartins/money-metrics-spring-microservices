package ao.statservice.domain.service;

import java.util.List;

import ao.statservice.domain.filter.TimeFilter;
import ao.statservice.domain.model.dto.AmountDto;
import ao.statservice.domain.model.dto.DiaryExpensesDto;
import ao.statservice.domain.model.dto.DiaryIncomesDto;
import ao.statservice.domain.model.dto.SavingDto;

public interface AdminStatsService {
	List<DiaryIncomesDto> getDiaryIncomes(TimeFilter filter);
	public List<SavingDto> getTopSavings(Integer top);
	public List<AmountDto> getTopCurrencies(Integer top);
	 List<DiaryExpensesDto> getDiaryExpense(TimeFilter filter);
}
