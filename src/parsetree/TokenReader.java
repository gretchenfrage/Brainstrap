package parsetree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import lexer.Token;

public class TokenReader {

	private List<Token> tokens;
	private int index = 0;
	
	public TokenReader(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	public Token read() throws NoSuchElementException {
		if (index >= tokens.size())
			throw new NoSuchElementException();
		index++;
		return tokens.get(index - 1);
	}
	
	public Token peek() throws NoSuchElementException {
		if (index >= tokens.size())
			throw new NoSuchElementException();
		return tokens.get(index);
	}
	
	public List<Token> read(int number) {
		List<Token> out = new ArrayList<Token>();
		while (number > 0) {
			if (index >= tokens.size())
				break;
			number--;
			out.add(tokens.get(index));
			index++;
		}
		return out;
	}
	
	public List<Token> peek(int number) {
		List<Token> out = new ArrayList<Token>();
		int peekIndex = index;
		while (peekIndex < tokens.size() && number > 0) {
			number--;
			out.add(tokens.get(peekIndex));
			peekIndex++;
		}
		return out;
	}
	
	public boolean hasNext() {
		return index < tokens.size();
	}
	
}