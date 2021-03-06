package ao.accountservice.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(insertable = false)
	private OffsetDateTime date;
	
	private String description;
	
	private Long savingId;
	
	private String accountId;
	
	private  BigDecimal amount;

	}

