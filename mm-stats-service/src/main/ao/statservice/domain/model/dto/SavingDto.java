package ao.statservice.domain.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@JsonInclude(value = Include.NON_NULL)
public class SavingDto {
	
	private String name;
	private BigDecimal amount;
	private String currencyCode;
	
	@Setter
	private Float percentage=null;
	
	//
	private String owner=null;
	private Integer rank=null;
	private float growthOnLastMonth;
	
		
	public SavingDto(BigDecimal amount, String name,String currencyCode, String fullName) {
		this(name,amount,currencyCode);
		this.owner=fullName;
	}
	
	public SavingDto(String name, BigDecimal amount, String currencyCode) {
		this.name = name;
		this.amount = amount;
		this.currencyCode = currencyCode;
	}
}
