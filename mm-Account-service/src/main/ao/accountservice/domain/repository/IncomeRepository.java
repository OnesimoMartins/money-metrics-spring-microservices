package ao.accountservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.accountservice.domain.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {

}
