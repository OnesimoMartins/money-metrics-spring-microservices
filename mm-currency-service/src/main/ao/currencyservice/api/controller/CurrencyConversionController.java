package ao.currencyservice.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ao.currencyservice.api.dto.response.CurrencyExchangeResponse;
import ao.currencyservice.api.dto.response.CurrencyResponse;
import ao.currencyservice.api.openapi.controller.CurrencyConversionControllerOpenApi;
import ao.currencyservice.domain.service.CurrencyService;

@RestController
public class CurrencyConversionController implements CurrencyConversionControllerOpenApi {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/{amount}")
	public CurrencyExchangeResponse convert(@PathVariable("from") String fromId
			,@PathVariable("to") String toId,@PathVariable BigDecimal amount) {

		var from=currencyService.getCurrencieById(fromId);
		var to=currencyService.getCurrencieById(toId);
		
	    var result=currencyService.conversionCurrencies(from,to,amount);
	   var port=env.getProperty("server.port");
       
		return CurrencyExchangeResponse.builder()
				.Envaironment(port)
				
				.from(new CurrencyResponse(from.getId(),from.getName(), from.getSymbol()))
				.to(new CurrencyResponse(to.getId(),to.getName(), to.getSymbol()))
				.totalCalculatedAmount(
				result).build();
	}
	

}
