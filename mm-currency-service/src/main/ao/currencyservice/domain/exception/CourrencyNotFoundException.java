package ao.currencyservice.domain.exception;

public class CourrencyNotFoundException extends   RuntimeException{

	private static final long serialVersionUID = 1L;

	public CourrencyNotFoundException(String msg) {
	super(msg);
	}
}
