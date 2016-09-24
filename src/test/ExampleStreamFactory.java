package test;

import java.io.InputStream;

public class ExampleStreamFactory {

	public static InputStream of(String name) {
		return ExampleStreamFactory.class.getClassLoader().getResourceAsStream("example/" + name + ".bs");
	}
	
}
