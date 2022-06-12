package ao.accountservice.domain.exception;

public class AccountNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 7358891341041590083L;
	public AccountNotFound(String msg) {
		super(msg);
	}
}
