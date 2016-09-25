package parsetree;

import java.util.List;

public class MacroNode extends Node {

	private List<Node> params;
	private List<Node> contents;
	
	public MacroNode(TokenReader reader) {
		super(NodeType.MACRO);
	}
	
	
	
}
