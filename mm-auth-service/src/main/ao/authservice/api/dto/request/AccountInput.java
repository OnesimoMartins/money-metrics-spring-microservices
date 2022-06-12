package ao.authservice.api.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class AccountInput {
//		
//		@NotNull
//		private String firstName;
//		
//		@NotNull
//		private String lastName;

	@NotNull
//		@UsernameNotUsed
	private String username;

	@Size(min = 8, max = 15)
	private String password;

}
