package networking;
// when unable to
public class UnableToConnectToServerException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnableToConnectToServerException(String message) {
		super(message);
	}
}
