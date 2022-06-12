package ao.accountservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.accountservice.domain.exception.SavingNotExists;
import ao.accountservice.domain.model.Saving;
import ao.accountservice.domain.repository.SavingRepository;

@Service
public class SavingService {

	@Autowired private SavingRepository savings;
	
	public Saving getSavingById(Long id) {
	return 	savings.findById(id).orElseThrow(
				()->new SavingNotExists("create a saving"));
	}

}
