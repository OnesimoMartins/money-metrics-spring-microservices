package ao.accountservice.api.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ao.accountservice.core.validation.UsernameNotUsed;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountInput {
	
	@NotNull
	private String firstName;
	
	@NotNull
	
	private String lastName;
	
	@NotNull
	@UsernameNotUsed
	private String username;
	
	@Size(min=8,max=15)
	private String password;
}
