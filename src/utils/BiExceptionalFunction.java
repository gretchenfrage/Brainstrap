package utils;

public interface BiExceptionalFunction<A, B, C extends Exception, D extends Exception> {

	public B apply(A obj) throws C, D;
	
}
