package parsetree;

import java.util.List;
import java.util.Stack;

import lexer.Token;

public class ParseTreeFactory {

	public Node makeTree(List<Token> tokens) {
		Stack<Token> stack = new Stack<Token>();
		for (int i = tokens.size() - 1; i >= 0; i--) {
			stack.push(tokens.get(i));
		}
		
	}
	
}
