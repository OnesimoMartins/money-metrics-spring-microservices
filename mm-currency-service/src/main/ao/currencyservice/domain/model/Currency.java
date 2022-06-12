package ao.currencyservice.domain.model;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(value = "Currency")
@Getter
@Setter
@ToString
public class Currency {

	@Id
	private String id;
	private String name;
	private String symbol;

	// comparing to dollar
	private float rate;

	public BigDecimal toDollar(BigDecimal currency) {
		var dollarCurrecny = new BigDecimal(rate).multiply(currency, MathContext.DECIMAL32);
		return dollarCurrecny;
	}
	public BigDecimal fromDollarToThisCurrency(BigDecimal dollar) {
        var thisCurrency=dollar.divide(new BigDecimal(this.rate), MathContext.DECIMAL32);
		return thisCurrency;
	}

}
