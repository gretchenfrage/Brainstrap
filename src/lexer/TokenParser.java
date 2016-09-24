package lexer;

import java.io.IOException;

public interface TokenParser {

	boolean started(LexerReader reader) throws IOException;
	
	Token parse(LexerReader reader) throws IOException, IllegalStateException, IllegalSyntaxException;
	
}
