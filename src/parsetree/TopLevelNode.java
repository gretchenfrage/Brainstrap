package parsetree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import lexer.Token;

public class TopLevelNode implements Node {

	private List<Node> subNodes = new ArrayList<Node>();
	
	public TopLevelNode(Stack<Token> tokens) throws IllegalGrammarException {
		List<NodeFactory> nodeFactories = makeNodeFactories();
		while (!tokens.isEmpty()) {
			Optional<Node> node = makeNode(tokens, nodeFactories);
			if (node.isPresent())
				subNodes.add(node.get());
			else
				throw new IllegalGrammarException();
		}
	}
	
	private Optional<Node> makeNode(Stack<Token> tokens, List<NodeFactory> nodeFactories) throws IllegalGrammarException {
		for (NodeFactory factory : nodeFactories) {
			if (factory.started(tokens))
				return Optional.of(factory.make(tokens));
		}
		return Optional.empty();
	}
	
	private static List<NodeFactory> makeNodeFactories() {
		List<NodeFactory> out = new ArrayList<NodeFactory>();
		
		return out;
	}
	
}
