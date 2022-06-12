package ao.currencyservice.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CurrencyResponse {
	private String id;
	private String name;
	private String symbol;
	
	public CurrencyResponse(String name,String symbol){
		this.name=name;
		this.symbol=symbol;
	}
}
