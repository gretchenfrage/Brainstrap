package parsetree;

public class IllegalGrammarException extends Exception {

	private static final long serialVersionUID = 7001658209831763073L;

	public IllegalGrammarException() {}

	public IllegalGrammarException(String reason) {
		super(reason);
	}

	public IllegalGrammarException(Throwable reason) {
		super(reason);
	}
	
	

}
