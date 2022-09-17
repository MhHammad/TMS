package custom_exceptions;

@SuppressWarnings("serial")
public class HomeMakerHandlingException extends RuntimeException {
	public HomeMakerHandlingException(String mesg) {
		super(mesg);
	}
}
