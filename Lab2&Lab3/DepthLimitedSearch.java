package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {

	public Node execute(Node root, String goal, int limit) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		ArrayList<Node> ex = new ArrayList<Node>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			ex.add(current);
			if (current.getLabel().equals(goal))
				return current;
			else if (limit == 0)
				return null;
			List<Node> children = current.getChildrenNodes();
			for (Node child : children) {
				child.setParent(current);
				Node res = execute(child, goal, limit - 1);
				if (res != null)
					return res;
			}
		}

		return null;
	}

}
