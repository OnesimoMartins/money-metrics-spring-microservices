package ao.currencyservice.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.currencyservice.api.dto.request.CurrencyUpdateRateInput;
import ao.currencyservice.api.dto.response.CurrencyResponse;
import ao.currencyservice.api.dto.util.RequestUtils;
import ao.currencyservice.api.openapi.controller.CurrencyControllerOpenApi;
import ao.currencyservice.domain.model.Currency;
import ao.currencyservice.domain.service.CurrencyService;

@RestController
public class CurrencyController implements CurrencyControllerOpenApi {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping("v1/courrencies")
	public List<CurrencyResponse> getCurrencies() {
		return RequestUtils.toCurrencyResponseList(currencyService.getAll());
	}

	@PatchMapping("v1/courrency/{id}/update-rate")
	public Currency updateRate(@RequestBody @Valid CurrencyUpdateRateInput input, @PathVariable String id) {
		return currencyService.updateCurrencyRate(input.getRate(), id);
	}
}
