package ao.currencyservice.api.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CurrencyExchangeResponse {

	private CurrencyResponse from;
	private CurrencyResponse to;
	
	private BigDecimal totalCalculatedAmount;
	private String Envaironment;
	

}
