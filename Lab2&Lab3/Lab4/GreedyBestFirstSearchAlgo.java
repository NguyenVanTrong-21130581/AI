package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(20, new NodeComparator());
		frontier.add(root);
		ArrayList<Node> ex = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
				
			}else {
				ex.add(current);
				List<Edge> children = current.getChildren();
				for (Edge e : children) {
					Node child = e.getEnd();
					if(!frontier.contains(child) && !ex.contains(child)) {
						child.setG(current.getG() + e.getWeight());
						child.setParent(current);
						frontier.add(child);
					}else if(frontier.contains(child) && child.getG() > current.getG() + e.getWeight()) {
						frontier.remove(child);
						child.setParent(current);
						child.setG(current.getG() + e.getWeight());
						frontier.add(child);
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
