package parsetree;

public abstract class Node {

	private NodeType type;
	
	protected Node(NodeType type) {
		this.type = type;
	}
	
	public String string() {
		throw new WrongNodeTypeException();
	}
	
	public int integer() {
		throw new WrongNodeTypeException();
	}
	
	public void put(String key, Node node) {
		throw new WrongNodeTypeException();
	}
	
	public Node get(String key) {
		throw new WrongNodeTypeException();
	}
	
	public void add(Node node) {
		throw new WrongNodeTypeException();
	}
	
	public Node get(int index) {
		throw new WrongNodeTypeException();
	}
	
	public int length() {
		throw new WrongNodeTypeException();
	}
	
	public NodeType type() {
		return type;
	}
	
}
