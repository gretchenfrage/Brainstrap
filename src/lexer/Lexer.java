package lexer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lexer {
	
	private List<TokenParser> parsers = makeParsers();
	
	public List<Token> lexify(InputStream in, Charset charset) throws IOException, IllegalSyntaxException {
		LexerReader reader = new LexerReader(in, charset);
		List<Token> tokens = new ArrayList<Token>();
		while (!reader.done()) {
			reader.skipWhitespace();
			Optional<Token> token = parseToken(reader);
			if (token.isPresent())
				tokens.add(token.get());
			else
				throw new IllegalSyntaxException();
		}
		return tokens;
	}
	
	public List<Token> lexify(InputStream in) throws IOException, IllegalSyntaxException {
		return lexify(in, Charset.defaultCharset());
	}
	
	private Optional<Token> parseToken(LexerReader reader) throws IOException, IllegalSyntaxException {
		for (TokenParser parser : parsers) {
			if (parser.started(reader))
				return Optional.of(parser.parse(reader));
		}
		return Optional.empty();
	}
	
	private static List<TokenParser> makeParsers() {
		List<TokenParser> out = new ArrayList<TokenParser>();
		out.add(new ExactMatchParser(";", TokenType.SEMICOLON));
		out.add(new ExactMatchParser("declare", TokenType.DECLARE));
		out.add(new ExactMatchParser("delete", TokenType.DELETE));
		out.add(new ExactMatchParser("while", TokenType.WHILE));
		out.add(new ExactMatchParser("output", TokenType.OUTPUT));
		out.add(new ExactMatchParser("input", TokenType.INPUT));
		out.add(new ExactMatchParser("{", TokenType.OPEN_CURLY_BRACKET));
		out.add(new ExactMatchParser("}", TokenType.CLOSE_CURLY_BRACKET));
		out.add(new ExactMatchParser("(", TokenType.OPEN_PARENTHESIS));
		out.add(new ExactMatchParser(")", TokenType.CLOSE_PARENTHESIS));
		out.add(new ExactMatchParser("macro", TokenType.MACRO));
		out.add(new ExactMatchParser("++", TokenType.INCREMENT));
		out.add(new ExactMatchParser("--", TokenType.DECREMENT));
		out.add(new ExactMatchParser("+=", TokenType.PLUS_EQUALS));
		out.add(new ExactMatchParser("-=", TokenType.MINUS_EQUALS));
		out.add(new ExactMatchParser(",", TokenType.COMMA));
		out.add(new ByteLiteralParser());
		out.add(new CharLiteralParser());
		out.add(new IdentifierParser());
		return out;
	}
	
}
