package ao.statservice.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DiaryExpensesDto {

	private LocalDate date;
	private BigDecimal amount;
	private long totalExpenses;
	private long womanExpenses;
	private long manInExpenses;
	
	public DiaryExpensesDto(OffsetDateTime date, BigDecimal amount, long totalExpenses, long womanExpenses,
			long manInExpenses) {
		super();
		this.date = date.toLocalDate();
		this.amount = amount;
		this.totalExpenses = totalExpenses;
		this.womanExpenses = womanExpenses;
		this.manInExpenses = manInExpenses;
	}
}
