package ao.accountservice.api.dto;

import ao.accountservice.api.dto.response.AccountResponse;
import ao.accountservice.domain.model.Account;

public class ResponseUtils {

	public static AccountResponse convetToAccountResponse(Account account) {
		var fullName=account.getFirstName()+" "+account.getLastName();
		return new AccountResponse(account.getId(),account.getUsername(),fullName);
	}

}
