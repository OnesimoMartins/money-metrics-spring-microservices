package ao.statservice.domain.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;

@Getter
public class TopSavingsDto {

	private BigDecimal totalAmount;
	private List<SavingDto> savings;
}
