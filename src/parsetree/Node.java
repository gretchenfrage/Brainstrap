package parsetree;

public abstract class Node {

	private NodeType type;
	
	public Node(NodeType type) {
		this.type = type;
	}
	
	public NodeType type() {
		return type;
	}
	
}
