package parsetree;

public class WrongNodeTypeException extends RuntimeException {

	private static final long serialVersionUID = -5696785201489056033L;

	public WrongNodeTypeException() {
		super();
	}

	public WrongNodeTypeException(String arg0) {
		super(arg0);
	}

	public WrongNodeTypeException(Throwable arg0) {
		super(arg0);
	}

}
