package ao.authservice.api.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.authservice.api.dto.request.AccountInput;
import ao.authservice.core.webutils.ResponseUtils;
import ao.authservice.domain.model.Account;
import ao.authservice.domain.repository.AccountRepository;
import ao.authservice.domain.repository.AuthorityRepository;
import ao.authservice.domain.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;	
	@Autowired
	private AccountRepository accounts;	
	@Autowired
	private AuthorityRepository authorities;

	  @PostMapping
		public Account createAccount(@RequestBody @Valid AccountInput accountInput) {
		  var newAccount=ResponseUtils.convertToAccount(accountInput);
		  newAccount.addAuthority(authorities.findAuthorityByName("user".toUpperCase()));
		  return accounts.save(newAccount);
		}

	@GetMapping(value = "teste")
	@PostConstruct
	public String getMethodName() {
//		System.out.println(accounts.findAccountByUsername("rafa22")+"\n");
		//accounts.findAll().forEach(System.out::println);
		return "Testado";
	}

}
