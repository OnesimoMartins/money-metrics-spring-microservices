package ao.accountservice.api.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IncomeInput {
	
	@NotNull
	private Long savingId;
	private String description;
	
	@NotNull
	private BigDecimal amount;

}
