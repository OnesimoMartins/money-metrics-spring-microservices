package ao.accountservice.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Saving {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal amount;
	private String name;
    private String currencyCode;
    
    public void addAmount(final BigDecimal amount) {
    	this.amount.add(amount);
    }
    public void subtractAmount(final BigDecimal amount) {
    	this.amount.subtract(amount);
    }
    public void changeCurrency(final String currencyCode, final BigDecimal amount) {
    	this.amount=amount;
    	this.currencyCode=currencyCode;
    }
}
