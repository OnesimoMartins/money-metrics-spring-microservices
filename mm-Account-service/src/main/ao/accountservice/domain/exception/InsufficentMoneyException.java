package ao.accountservice.domain.exception;

public class InsufficentMoneyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficentMoneyException(String msg) {
		super(msg);
	}
}
