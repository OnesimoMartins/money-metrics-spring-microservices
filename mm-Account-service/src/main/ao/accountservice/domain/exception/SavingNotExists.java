package ao.accountservice.domain.exception;

public class SavingNotExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SavingNotExists(String msg) {
	super(msg);
	}
}
