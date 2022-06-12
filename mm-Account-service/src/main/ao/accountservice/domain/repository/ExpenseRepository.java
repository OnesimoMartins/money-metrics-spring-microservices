package ao.accountservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.accountservice.domain.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
