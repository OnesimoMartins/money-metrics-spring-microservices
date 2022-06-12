package ao.statservice.infrastructure;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import ao.statservice.domain.filter.TimeFilter;
import ao.statservice.domain.model.dto.AmountDto;
import ao.statservice.domain.model.dto.DiaryExpensesDto;
import ao.statservice.domain.model.dto.DiaryIncomesDto;
import ao.statservice.domain.model.dto.SavingDto;
import ao.statservice.domain.service.AdminStatsService;

@Service
public class AdminStatsQueryImpl implements AdminStatsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<DiaryIncomesDto> getDiaryIncomes(TimeFilter filter) {

		var jpql = "select new ao.statservice.domain.model.dto.DiaryIncomesDto( i.date,sum(i.amount), count( i.id), "
				+ "count(case a.gender when 'FEMALE' then 1 else null end), "
				+ "count(case a.gender when 'MALE' then 1 else null end)) "
				+ " from Income i inner join Saving s on s.id=i.savingId inner join Account a on a.id=s.accountId "
				+ " WHERE i.date BETWEEN :since and :until group by date";

		var since = filter.getSince() != null ? filter.getSince() : LocalDate.now().withMonth(01).withDayOfMonth(01);

		var until = filter.getUntil() != null ? filter.getUntil() : LocalDate.now();

		TypedQuery<DiaryIncomesDto> incomes = manager.createQuery(jpql, DiaryIncomesDto.class);
		incomes.setParameter("since", since);
		incomes.setParameter("until", until);

		return incomes.getResultList();
	}

	@Override
	public List<DiaryExpensesDto> getDiaryExpense(TimeFilter filter) {
		var jpql = "select new ao.statservice.domain.model.dto.DiaryExpensesDto(i.date,sum(i.amount), count( i.id), "
				+ "count(case a.gender when 'FEMALE' then 1 else null end), "
				+ "count(case a.gender when 'MALE' then 1 else null end)) "
				+ " from Expense i inner join Saving s on s.id=i.savingId inner join Account a on a.id=s.accountId "
				+ " WHERE i.date BETWEEN :since and :until " + " group by date";

		TypedQuery<DiaryExpensesDto> incomes = manager.createQuery(jpql, DiaryExpensesDto.class);

		var since = filter.getSince() != null ? filter.getSince() : LocalDate.now().withMonth(01).withDayOfMonth(01);

		var until = filter.getUntil() != null ? filter.getUntil() : LocalDate.now();

		incomes.setParameter("since", since);
		incomes.setParameter("until", until);

		return incomes.getResultList();
	}

	@Override
	public List<SavingDto> getTopSavings(Integer top) {

		var jpql = "select new ao.statservice.domain.model.dto.SavingDto("
				+ " s.amount,s.name,s.currencyCode, concat(a.firstName,' ',a.lastName) )"
				+ "from Saving s inner join Account a on a.id= s.accountId " + "order by amount desc ";

		TypedQuery<SavingDto> topSavings = manager.createQuery(jpql, SavingDto.class);

		if (top == null)
			topSavings.setMaxResults(10);
		else
			topSavings.setMaxResults(top);

		return topSavings.getResultList();
	}

	@Override
	public List<AmountDto> getTopCurrencies(Integer top) {

		var jpql = "select new ao.statservice.infrastructure.AmountDto(sum(s.amount),s.currencyCode,count(id)) "
				+ " from Saving s group by currencyCode";

		TypedQuery<AmountDto> topSavings = manager.createQuery(jpql, AmountDto.class);

		if (top == null)
			topSavings.setMaxResults(10);
		else
			topSavings.setMaxResults(top);

		return topSavings.getResultList();
	}

}
