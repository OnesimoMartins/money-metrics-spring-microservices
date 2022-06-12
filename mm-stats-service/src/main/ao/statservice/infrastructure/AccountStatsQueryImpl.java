package ao.statservice.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import ao.statservice.domain.model.Expense;
import ao.statservice.domain.model.Income;
import ao.statservice.domain.model.dto.AccountSavingsDto;
import ao.statservice.domain.model.dto.ExpenseDto;
import ao.statservice.domain.model.dto.IncomeDto;
import ao.statservice.domain.model.dto.SavingDto;
import ao.statservice.domain.service.AccountStatsService;

@Service
public class AccountStatsQueryImpl implements AccountStatsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ExpenseDto> getTopExpenses(Integer top) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<ExpenseDto> query = criteriaBuilder.createQuery(ExpenseDto.class);
		Root<Expense> root = query.from(Expense.class);
		Order order = criteriaBuilder.desc(root.get("amount"));
		query.select(criteriaBuilder.construct(ExpenseDto.class, root.get("amount"), root.get("date")));
		query.orderBy(order);
		TypedQuery<ExpenseDto> typedQuery = manager.createQuery(query);
		return typedQuery.setMaxResults(top).getResultList();

	}

	@Override
	public List<IncomeDto> getTopIncomes(Integer top) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<IncomeDto> criteriaQuery = criteriaBuilder.createQuery(IncomeDto.class);
		Root<Income> root = criteriaQuery.from(Income.class);
		Order order = criteriaBuilder.desc(root.get("amount"));
		criteriaQuery.select(criteriaBuilder.construct(IncomeDto.class, root.get("amount"), root.get("date")));
		criteriaQuery.orderBy(order);
		TypedQuery<IncomeDto> incomesResult = manager.createQuery(criteriaQuery);
		return incomesResult.setMaxResults(top).getResultList();
	}

	@Override
	public AccountSavingsDto getMoneyPercentage(Long id) {
		var jpql = "select new ao.statservice.domain.model.dto.SavingDto(s.name,s.amount,s.currencyCode) "
				+ "from Saving s where s.accountId =: id";
		TypedQuery<SavingDto> savings = manager.createQuery(jpql, SavingDto.class);
		savings.setParameter("id", id);
		return new AccountSavingsDto(savings.getResultList());
	}
}