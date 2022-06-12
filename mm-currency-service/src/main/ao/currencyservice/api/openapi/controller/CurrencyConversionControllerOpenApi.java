package ao.currencyservice.api.openapi.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;

import ao.currencyservice.api.dto.response.CurrencyExchangeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="currency-conversion")
public interface CurrencyConversionControllerOpenApi {

	@ApiOperation("Convert amount to another currency ")
	public CurrencyExchangeResponse convert(@PathVariable String fromId
			,@PathVariable String toId,@PathVariable BigDecimal amount);
}
