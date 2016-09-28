package parsetree;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends Node {

	private List<Node> contents = new ArrayList<Node>();
	
	public ListNode(NodeType type) {
		super(type);
	}
	
	@Override
	public void add(Node node) {
		contents.add(node);
	}
	
	@Override
	public Node get(int index) {
		return contents.get(index);
	}
	
	@Override
	public int length() {
		return contents.size();
	}
	
}
