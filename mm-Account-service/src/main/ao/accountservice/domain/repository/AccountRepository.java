package ao.accountservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.accountservice.domain.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	public Account findAccounttByUsername(String username);
}
