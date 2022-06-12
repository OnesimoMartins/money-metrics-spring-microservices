package ao.accountservice.api.exceptionhandler;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationErrorObject {

	private String name;
	private String message;
	private List<String> usernameSugestions;
}
