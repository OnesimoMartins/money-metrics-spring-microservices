package ao.authservice.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPayload {
	
private String username;
private String password;
}
