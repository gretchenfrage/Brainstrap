package lexer;

import java.io.IOException;

public class IdentifierParser implements TokenParser {
	
	private static boolean validStarter(String str) {
		if (str.isEmpty())
			return false;
		else {
			char c = str.charAt(0);
			return Character.isAlphabetic(c) || c == '_';
		}
	}
	
	private static boolean valid(String str) {
		if (str.isEmpty())
			return false;
		else if (validStarter(str))
			return true;
		else
			return Character.isDigit(str.charAt(0));
	}
	
	@Override
	public boolean started(LexerReader reader) throws IOException {
		return validStarter(reader.peek(1));
	}

	@Override
	public Token parse(LexerReader reader) throws IOException, IllegalStateException, IllegalSyntaxException {
		if (!started(reader))
			throw new IllegalStateException();
		
		StringBuilder builder = new StringBuilder();
		boolean valid;
		do {
			String next = reader.peek(1);
			valid = valid(next);
			if (valid) {
				reader.read(1);
				builder.append(next);
			}
		} while (valid);
		
		return new Token(TokenType.IDENTIFIER, builder.toString());
	}

}
