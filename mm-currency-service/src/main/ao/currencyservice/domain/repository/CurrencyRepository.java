package ao.currencyservice.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ao.currencyservice.domain.model.Currency;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String> {

}
