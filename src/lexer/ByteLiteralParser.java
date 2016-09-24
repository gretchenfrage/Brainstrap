package lexer;

import java.io.IOException;

public class ByteLiteralParser implements TokenParser {
	
	private static boolean digit(String str) {
		if (str.isEmpty())
			return false;
		else
			return Character.isDigit(str.charAt(0));		
	}
	
	@Override
	public boolean started(LexerReader reader) throws IOException {
		return digit(reader.peek(1));
	}

	@Override
	public Token parse(LexerReader reader) throws IOException, IllegalStateException, IllegalSyntaxException {
		StringBuilder builder = new StringBuilder();
		boolean digit;
		do {
			digit = digit(reader.peek(1));
			if (digit) {
				builder.append(reader.read(1));
			}
		} while (digit);
		
		try {
			int n = Integer.parseInt(builder.toString());
			if (n < 0 || n > 255)
				throw new IllegalSyntaxException("Byte literal out of bounds: " + n);
		} catch (NumberFormatException e) {
			throw new IllegalSyntaxException(e);
		}
		
		return new Token(TokenType.BYTE_LITERAL, builder.toString());
	}

}
