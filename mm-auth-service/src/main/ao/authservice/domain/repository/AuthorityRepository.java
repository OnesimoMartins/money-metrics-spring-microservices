package ao.authservice.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ao.authservice.domain.model.Authority;

@Repository
public interface AuthorityRepository extends MongoRepository<Authority, String> {
	public Authority findAuthorityByName(String name);
}
