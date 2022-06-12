package ao.accountservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.accountservice.api.dto.RequestUtils;
import ao.accountservice.api.dto.ResponseUtils;
import ao.accountservice.api.dto.request.AccountInput;
import ao.accountservice.api.dto.response.AccountResponse;
import ao.accountservice.domain.repository.AccountRepository;
import ao.accountservice.domain.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountRepository accountRepository;
	


	@GetMapping("/{id}")
	public AccountResponse getAccount(@PathVariable Long id) {
		return ResponseUtils.convetToAccountResponse(accountService.getAccountById(id));
		//hateoas--savings
	}

}
