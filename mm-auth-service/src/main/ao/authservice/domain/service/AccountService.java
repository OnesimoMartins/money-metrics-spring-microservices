package ao.authservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ao.authservice.domain.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

	@Autowired private AccountRepository accountRepository;
	
	//reuturns true if there is an account with this username else false
	public boolean checkUsername(String value) {
		return accountRepository.findAccountByUsername(value)==null? false:true;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findAccountByUsername(username).orElseThrow(
				()->new UsernameNotFoundException("invalid username")
				);
				
				
	}
}
