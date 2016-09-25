package lexer;

public class Token {

	private TokenType type;
	private String contents;
	
	public Token(TokenType type, String contents) {
		this.type = type;
		this.contents = contents;
	}
	
	public TokenType type() {
		return type;
	}
	
	public boolean is(TokenType type) {
		return this.type == type;
	}
	
	public String contents() {
		return contents;
	}
	
	@Override
	public String toString() {
		return type + ": \"" + contents + "\"";
	}
	
}
