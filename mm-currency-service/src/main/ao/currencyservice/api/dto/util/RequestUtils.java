package ao.currencyservice.api.dto.util;

import java.util.ArrayList;
import java.util.List;

import ao.currencyservice.api.dto.response.CurrencyResponse;
import ao.currencyservice.domain.model.Currency;

public class RequestUtils {

	public static List<CurrencyResponse> toCurrencyResponseList(List<Currency> currencies) {
		var response = new ArrayList<CurrencyResponse>();
		currencies.forEach(it -> response.add(new CurrencyResponse(it.getId(), it.getName(), it.getSymbol()
				)));
		return response;
	}
}
