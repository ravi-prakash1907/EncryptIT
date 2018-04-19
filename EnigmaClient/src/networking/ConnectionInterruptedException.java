package networking;

public class ConnectionInterruptedException extends Exception {
	private static final long serialVersionUID = 2L;

	public ConnectionInterruptedException(String message) {
		super(message);
	}
}
