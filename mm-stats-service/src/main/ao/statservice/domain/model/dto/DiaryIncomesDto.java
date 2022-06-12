package ao.statservice.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class DiaryIncomesDto {

	private LocalDate date;
	private BigDecimal amount;
	private long totalIncomes;
	private long womanIncomes;
	private long manIncomes;
	
}
