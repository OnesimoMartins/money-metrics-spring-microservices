package ao.currencyservice.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ao.currencyservice.domain.exception.CourrencyNotFoundException;
import ao.currencyservice.domain.model.Currency;
import ao.currencyservice.domain.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencies;

	public Currency getCurrencieById(String id) {
		return currencies.findById(id).orElseThrow(()
				-> new CourrencyNotFoundException("there is not cunrrency with id "+id));
	}

	public List<Currency> getAll() {
		return currencies.findAll();
	}

	public BigDecimal conversionCurrencies(Currency from, Currency to, BigDecimal amount) {
		var fromAsDollar =from.toDollar(amount);
		var result = to.fromDollarToThisCurrency(fromAsDollar);
		return result;
	}

	@Transactional
	public Currency updateCurrencyRate(float rate,String currencyId) {
		var old=this.getCurrencieById(currencyId);
		old.setRate(rate);
		return this.currencies.save(old);
	}


}
