package ao.authservice.core.webutils;

import ao.authservice.api.dto.request.AccountInput;
import ao.authservice.domain.model.Account;

public class ResponseUtils {

	public static Account convertToAccount( AccountInput accountInput) {
	  var account=new Account();
	  
	  account.setUsername(accountInput.getUsername());
	  account.setPassword(accountInput.getPassword());
	  
		return account;
	}

}
