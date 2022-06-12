package ao.accountservice.api.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import ao.accountservice.core.validation.HasEnoughMoneyOnSaving;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@HasEnoughMoneyOnSaving
public class ExpenseInput {
	
	@NotNull private Long savingId;
	private String description;
	@NotNull private BigDecimal amount;
}
