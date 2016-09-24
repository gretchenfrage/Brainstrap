package lexer;

import java.io.IOException;

public class ExactMatchParser implements TokenParser {

	private String match;
	private Token token;
	
	public ExactMatchParser(String match, TokenType type) {
		this.match = match;
		this.token = new Token(type, match);
	}
	
	@Override
	public boolean started(LexerReader reader) throws IOException {
		return reader.peek(match.length()).equals(match);
	}

	@Override
	public Token parse(LexerReader reader) throws IOException, IllegalStateException, IllegalSyntaxException {
		if (reader.read(match.length()).equals(match))
			return token;
		else
			throw new IllegalStateException();
	}

}
