package parsetree;

import java.util.ArrayList;
import java.util.List;

import lexer.TokenType;

public class TopLevelNode extends Node {

	private List<Node> contents = new ArrayList<Node>();
	
	public TopLevelNode(TokenReader reader) {
		super(NodeType.TOP_LEVEL);
		while (!reader.done()) {
			if (reader.peek().is(TokenType.MACRO)) {
				
			}
		}
	}
	
}
