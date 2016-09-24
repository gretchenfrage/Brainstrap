package lexer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class LexerReader {

	private static final int PUSHBACK_BUFFER_SIZE = 512;
	
	private PushbackInputStream in;
	private Charset charset;
	
	public LexerReader(InputStream in, Charset charset) {
		this.in = new PushbackInputStream(in, PUSHBACK_BUFFER_SIZE);
		this.charset = charset;
	}
	
	public LexerReader(InputStream in) {
		this(in, Charset.defaultCharset());
	}
	
	public boolean done() throws IOException {
		return in.available() == 0;
	}
	
	public String read(int length) throws IOException {
		byte[] arr = new byte[length];
		int read = in.read(arr);
		if (read == -1)
			return "";
		ByteBuffer buffer = ByteBuffer.wrap(arr, 0, read);
		return charset.decode(buffer).toString();
	}
	
	public String peek(int length) throws IOException {
		byte[] arr = new byte[length];
		int read = in.read(arr);
		if (read == -1)
			return "";
		in.unread(arr, 0, read);
		ByteBuffer buffer = ByteBuffer.wrap(arr, 0, read);
		return charset.decode(buffer).toString();
	}
	
	public void skipWhitespace() throws IOException {
		boolean done = false;
		while (!done) {
			String str = peek(1);
			if (str.isEmpty())
				done = true;
			else
				if (Character.isWhitespace(str.charAt(0)))
					read(1);
				else
					done = true;
		}
	}
	
}
