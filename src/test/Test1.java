package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import lexer.IllegalSyntaxException;
import lexer.Lexer;
import lexer.Token;

public class Test1 {

	public static void main(String[] args) throws IOException, IllegalSyntaxException {
		InputStream in = ExampleStreamFactory.of("hhhhh");
		Lexer lexer = new Lexer();
		List<Token> tokens = lexer.lexify(in);
		System.out.println(tokens);
	}

}
