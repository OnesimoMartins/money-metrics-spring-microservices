package ao.accountservice.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(value = Include.NON_NULL)
public class ProblemModel {
	final private OffsetDateTime timestamp=OffsetDateTime.now();
	final private int status;
	final private String tittle;
	final private String type;
	final private String details;
	private List<ValidationErrorObject> errorFields;
	
  
}
