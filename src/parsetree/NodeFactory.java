package parsetree;

import java.util.Stack;
import java.util.function.Predicate;

import lexer.Token;
import utils.BiExceptionalFunction;

public class NodeFactory {

	private Predicate<Stack<Token>> started;
	private BiExceptionalFunction<Stack<Token>, Node, IllegalStateException, IllegalGrammarException> constructor;
	
	public NodeFactory(Predicate<Stack<Token>> started,
			BiExceptionalFunction<Stack<Token>, Node, IllegalStateException, IllegalGrammarException> constructor) {
		this.started = started;
		this.constructor = constructor;
	}

	public boolean started(Stack<Token> tokens) {
		return started.test(tokens);
	}
	
	public Node make(Stack<Token> tokens) throws IllegalStateException, IllegalGrammarException {
		if (!started(tokens))
			throw new IllegalStateException();
		return constructor.apply(tokens);
	}
	
}
