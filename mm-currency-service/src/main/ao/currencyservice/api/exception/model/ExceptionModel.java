package ao.currencyservice.api.exception.model;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@ApiModel("Error")
@Schema(name="Error")
public class ExceptionModel {
	
	
	@ApiModelProperty(example = "400",position = 1)
	private int status;
	@ApiModelProperty(example = "currency Id not found",position = 4)
	private String tittle;
	@ApiModelProperty(position = 2)
	private OffsetDateTime timestamp;
	@ApiModelProperty(position = 3)
	private String message;
}
