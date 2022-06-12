package ao.authservice.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ao.authservice.domain.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
	Optional<Account> findAccountByUsername(String value);
}
