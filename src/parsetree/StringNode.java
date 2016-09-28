package parsetree;

public class StringNode extends Node {

	private String string;
	
	public StringNode(NodeType type, String string) {
		super(type);
		this.string = string;
	}
	
	@Override
	public String string() {
		return string;
	}
	
	
}
