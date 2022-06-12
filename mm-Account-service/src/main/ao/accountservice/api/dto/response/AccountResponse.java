package ao.accountservice.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AccountResponse {
	
	private Long id;
	private String username;
	private String fullName;
	//private List<Saving> savings;
}
