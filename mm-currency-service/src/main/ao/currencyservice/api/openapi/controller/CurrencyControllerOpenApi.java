package ao.currencyservice.api.openapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import ao.currencyservice.api.dto.request.CurrencyUpdateRateInput;
import ao.currencyservice.api.dto.response.CurrencyResponse;
import ao.currencyservice.domain.model.Currency;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="Currency")
public interface CurrencyControllerOpenApi {

	@ApiOperation("Get all available currencies")
	public List<CurrencyResponse> getCurrencies();

	@ApiOperation("Update the rate of an specific currency")
	@ApiResponses({
		@ApiResponse(
				code=404
				,message="Currency Not found"),
		@ApiResponse(code=401 ,message="Without Authorization to Update currency rate")
	})
	public Currency updateRate(
			@ApiParam(example = "1.5" ,value = " CurrencyRate")
			CurrencyUpdateRateInput input, 
			@ApiParam(example = "USD" ,value = "Id")
			@PathVariable String id) ;
	
	
}
