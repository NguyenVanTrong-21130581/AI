package Lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> explared = new ArrayList<>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			explared.add(current);
			List<Node> childen = current.getChildrenNodes();
			for (Node child : childen) {
				if(!frontier.contains(child) && explared.contains(child)) {
					frontier.add(child);
				
			child.setParent(current);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		
		return null;
	}
	

}
