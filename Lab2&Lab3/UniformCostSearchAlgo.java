package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		List<Node> explared = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Edge> childen = current.getChildren();
				for (Edge child : childen) {
					if (!explared.contains(child.getEnd())) {
						child.getEnd().setPathCost(current.getPathCost() + child.getWeight());
						frontier.add(child.getEnd());
						child.getEnd().setParent(current);

					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean isStart = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		ArrayList<Node> ex = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.remove();
			ex.add(current);
			if (current.getLabel().equals(start)) {
				isStart = true;
				while (!frontier.isEmpty()) {
					Node n = frontier.remove();
					n.setParent(null);
					n.setPathCost(0);
				}
				for (Node n : ex) {
					n.setParent(null);
					n.setPathCost(0);
				}
				ex.clear();
			}
			if (current.getLabel().equals(goal)) {
				if (isStart)
					return current;
			} else {
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					if (!ex.contains(child.getEnd())) {
						child.getEnd().setPathCost(current.getPathCost() + child.getWeight());
						frontier.add(child.getEnd());
						child.getEnd().setParent(current);
					}
				}
			}
		}

		return null;
	}

}
