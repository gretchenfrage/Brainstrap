package parsetree;

public class IntNode extends Node {

	private int n;
	
	public IntNode(NodeType type, int n) {
		super(type);
		this.n = n;
	}
	
	@Override
	public int integer() {
		return n;
	}
	
}
