package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		ArrayList<Node> ex = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			ex.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				List<Node> children = current.getChildrenNodes();
				children.sort((o1,o2)-> {
					return o2.compareTo(o1);
				});
				for (Node child : children) {
					if(!frontier.contains(child) && !ex.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
