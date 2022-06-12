package ao.accountservice.api.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ao.accountservice.api.reponsemodel.MoneyExchangeResponse;

//@FeignClient(name="mm-currency-service",url = "localhost:8000")
@FeignClient(name = "mm-currency-service")
public interface CurrencyApiProxy {
	@GetMapping("currency-conversion/from/{from}/to/{to}/{amount}")
	public MoneyExchangeResponse convert(@PathVariable String from
			, @PathVariable String to
			,@PathVariable BigDecimal amount);
}
