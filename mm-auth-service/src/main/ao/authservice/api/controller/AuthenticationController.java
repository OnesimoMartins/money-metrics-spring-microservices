package ao.authservice.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.authservice.domain.model.dto.LoginPayload;

@RestController
public class AuthenticationController {

	@PostMapping("path")
	public String postMethodName(@RequestBody LoginPayload login) {
		return login.getPassword();
	}
@GetMapping(value = "path")
public String getMethodName(@RequestBody LoginPayload login) {
	return login.getPassword();
}


}
