package ao.accountservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.accountservice.domain.model.Saving;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {

}
