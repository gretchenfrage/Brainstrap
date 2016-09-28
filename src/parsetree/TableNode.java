package parsetree;

import java.util.HashMap;
import java.util.Map;

public class TableNode extends Node {

	private Map<String, Node> contents = new HashMap<String, Node>();
	
	public TableNode(NodeType type) {
		super(type);
	}
	
	public TableNode(NodeType type, Object... items) {
		super(type);
		if (items.length % 2 != 0)
			throw new IllegalArgumentException();
		for (int i = 0; i < items.length; i += 2) {
			contents.put((String) items[i], (Node) items[i + 1]);
		}
	}
	
	@Override
	public void put(String key, Node node) {
		contents.put(key, node);
	}
	
	@Override
	public Node get(String key) {
		return contents.get(key);
	}
	
}
