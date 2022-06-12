package ao.statservice.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ao.statservice.domain.model.dto.AccountSavingsDto;
import ao.statservice.domain.model.dto.ExpenseDto;
import ao.statservice.domain.model.dto.IncomeDto;

@Service
public interface AccountStatsService {
	public List<ExpenseDto> getTopExpenses(Integer top);
	public List<IncomeDto> getTopIncomes(Integer top);
	public AccountSavingsDto getMoneyPercentage(Long id);
}
