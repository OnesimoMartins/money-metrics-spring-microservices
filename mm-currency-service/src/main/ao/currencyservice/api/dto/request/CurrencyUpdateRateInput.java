package ao.currencyservice.api.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class CurrencyUpdateRateInput {
	@NotNull(message="you must informe the new rate")
	private float rate;
}
