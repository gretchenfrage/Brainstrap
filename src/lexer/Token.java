package lexer;

public class Token {

	private TokenType type;
	private String contents;
	
	public Token(TokenType type, String contents) {
		this.type = type;
		this.contents = contents;
	}
	
	public TokenType getType() {
		return type;
	}
	
	public String getContents() {
		return contents;
	}
	
	@Override
	public String toString() {
		return type + ": \"" + contents + "\"";
	}
	
}
