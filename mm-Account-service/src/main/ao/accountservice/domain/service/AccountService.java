package ao.accountservice.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ao.accountservice.domain.exception.AccountNotFound;
import ao.accountservice.domain.model.Account;
import ao.accountservice.domain.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accounts;

	public Account getAccountById(Long id) {
		return this.accounts.findById(id).orElseThrow(() -> new AccountNotFound("there isn't account with this id"));
	}

	public List<String> getUsernameSuggestions(String username) {
		List<String> usernames = new ArrayList<String>();

		// while(usernames.size()!=4) {
		var x = StringUtils.trimLeadingCharacter(UUID.randomUUID().toString(), '-');
		var sugestion = username + "_" + x;
		// }
		usernames.add(sugestion);
		System.out.println(x);

		return usernames;
	}
}
