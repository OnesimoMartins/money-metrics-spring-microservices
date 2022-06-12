package ao.accountservice.api.dto.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(value = Include.NON_NULL)
public class SavingResponse {
	
	private Long id;
	
	private BigDecimal calculatedAmount;
	
	private BigDecimal amount;
	
	private String name;
    
	private String currencyCode;
	
	private String newCurrencyConde;
}
