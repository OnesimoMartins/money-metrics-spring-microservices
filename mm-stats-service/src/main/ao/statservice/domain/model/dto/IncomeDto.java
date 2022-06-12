package ao.statservice.domain.model.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;



@Getter
@ToString
@AllArgsConstructor
public class IncomeDto {

	private BigDecimal amount;
	private OffsetDateTime date;
}