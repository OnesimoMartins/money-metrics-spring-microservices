package ao.statservice.domain.model.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AmountDto {

	private BigDecimal amount;
	private BigDecimal amountInUSD;
	private String currencyCode;
	private long savingQuantity;
	
	public AmountDto(BigDecimal amount, String currencyCode, long savingQuantity) {
		this.amount = amount;
		this.currencyCode = currencyCode;
		this.savingQuantity = savingQuantity;
	}
	
}
