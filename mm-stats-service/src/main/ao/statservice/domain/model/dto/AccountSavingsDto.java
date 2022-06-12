package ao.statservice.domain.model.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountSavingsDto {

	public AccountSavingsDto(List<SavingDto> savings) {
		this.savings = savings;
		this.amount = savings.stream().map(it -> it.getAmount()).reduce((a, b) -> a.add(b)).get();
		savings.forEach(it -> it.setPercentage(
				it.getAmount().divide(amount, MathContext.DECIMAL32)
				.multiply(new BigDecimal(100), MathContext.DECIMAL32).floatValue()));
	}

	private BigDecimal amount;
	private List<SavingDto> savings;

}
