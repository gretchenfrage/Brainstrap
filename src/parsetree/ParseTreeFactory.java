package parsetree;

import java.util.List;

import lexer.Token;
import lexer.TokenType;

public class ParseTreeFactory {

	public static Node parse(List<Token> tokens) {
		return parse(new TokenReader(tokens));
	}

	public static Node parse(TokenReader reader) throws IllegalGrammarException {
		Node top = new ListNode(NodeType.TOP_LEVEL);
		while (reader.hasNext()) {
			if (reader.peek().is(TokenType.MACRO)) {
				top.add(parseMacro(reader));
			} else {
				top.add(parseDirective(reader));
			}
		}
		return top;
	}

	private static Token asrt(TokenReader reader, TokenType type) throws IllegalGrammarException {
		Token node = reader.read();
		if (!node.is(type))
			throw new IllegalGrammarException();
		return node;
	}

	private static Node parseMacro(TokenReader reader) throws IllegalGrammarException {
		asrt(reader, TokenType.MACRO);
		asrt(reader, TokenType.OPEN_PARENTHESIS);
		Node params = new ListNode(NodeType.PARAMETER_LIST);
		while (!reader.peek().is(TokenType.CLOSE_PARENTHESIS)) {
			if (reader.peek().is(TokenType.MACRO))
				params.add(new StringNode(NodeType.MACRO_PARAMETER, asrt(reader, TokenType.IDENTIFIER).contents()));
			else
				params.add(new StringNode(NodeType.VARIABLE_PARAMETER, asrt(reader, TokenType.IDENTIFIER).contents()));
		}
		asrt(reader, TokenType.CLOSE_PARENTHESIS);
		asrt(reader, TokenType.OPEN_CURLY_BRACKET);
		Node directives = new ListNode(NodeType.DIRECTIVE_LIST);
		while (!reader.peek().is(TokenType.CLOSE_CURLY_BRACKET)) {
			directives.add(parseDirective(reader));
		}
		return new TableNode(NodeType.MACRO, "params", params, "directives", directives);
	}

	private static Node parseDirective(TokenReader reader) throws IllegalGrammarException {
		if (reader.peek().is(TokenType.IDENTIFIER)) {
			String id = reader.read().contents();
			if (reader.peek().is(TokenType.INCREMENT)) {
				reader.read();
				return new TableNode(NodeType.INCREMENT, "id", new StringNode(NodeType.IDENTIFIER, id));
			} else if (reader.peek().is(TokenType.DECREMENT)) {
				reader.read();
				return new TableNode(NodeType.DECREMENT, "id", new StringNode(NodeType.IDENTIFIER, id));
			} else if (reader.peek().is(TokenType.PLUS_EQUALS)) {
				reader.read();
				return new TableNode(NodeType.INCREMENT_N, "id", new StringNode(NodeType.IDENTIFIER, id), "amount",
						new IntNode(NodeType.INT, Integer.parseInt(asrt(reader, TokenType.BYTE_LITERAL).contents())));
			} else if (reader.peek().is(TokenType.MINUS_EQUALS)) {
				reader.read();
				return new TableNode(NodeType.DECREMENT_N, "id", new StringNode(NodeType.IDENTIFIER, id), "amount",
						new IntNode(NodeType.INT, Integer.parseInt(asrt(reader, TokenType.BYTE_LITERAL).contents())));
			}
		} else if (reader.peek().is(Token))
	}

}
