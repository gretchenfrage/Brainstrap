package lexer;

import java.io.IOException;

public class CharLiteralParser implements TokenParser {

	@Override
	public boolean started(LexerReader reader) throws IOException {
		return reader.peek(1).equals("'");
	}

	@Override
	public Token parse(LexerReader reader) throws IOException, IllegalStateException, IllegalSyntaxException {
		if (!reader.read(1).equals("'"))
			throw new IllegalStateException();
		
		char c;
		
		String str = reader.read(1);
		if (str.isEmpty())
			throw new IllegalSyntaxException();
		else if (str.equals("\\")) {
			String escaped = reader.read(1);
			if (escaped.isEmpty())
				throw new IllegalSyntaxException();
			else if (escaped.equals("\\"))
				c = '\\';
			else if (escaped.equals("n"))
				c = '\n';
			else
				throw new IllegalSyntaxException();
		} else
			c = str.charAt(0);
		
		if (c < 0 || c > 255)
			throw new IllegalSyntaxException();
		
		if (!reader.read(1).equals("'"))
			throw new IllegalSyntaxException();
		
		return new Token(TokenType.CHAR_LITERAL, Character.toString(c));
	}

}
