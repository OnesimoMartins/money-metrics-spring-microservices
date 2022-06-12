package ao.accountservice.api.reponsemodel;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class MoneyExchangeResponse {
	
    private CurrencyResponse from;
    private CurrencyResponse to;
    private BigDecimal totalCalculatedAmount;
    private String envaironment;
}
