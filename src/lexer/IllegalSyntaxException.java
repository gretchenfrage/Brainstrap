package lexer;

public class IllegalSyntaxException extends Exception {

	private static final long serialVersionUID = -8043676855251984353L;

	public IllegalSyntaxException() {
		super();
	}

	public IllegalSyntaxException(String reason) {
		super(reason);
	}

	public IllegalSyntaxException(Throwable reason) {
		super(reason);
	}

}
