package Lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.getH() > o2.getH()) {
					return 1;
				}else return -1;			
			}		
		});
		ArrayList<Node> visited = new ArrayList<Node>();
		Node result = null;
		model.getInitialState().setH(model.computeH2(model.getInitialState()));
		queue.add(model.getInitialState());
		int i = 0;
		while(!queue.isEmpty() && i < 10) {
			Node current = queue.poll();
			System.out.println(current.getH());
			if(current.getH() == 0) {
				result = current;
				return result;
			}else {
				for (Node nd : model.getSuccessors(current)) {
					if(!visited.contains(nd) && !queue.contains(nd)) {
						System.out.println(nd.getH() + " ");
						queue.add(nd);
						nd.setG(current.getG() + 1);
					}
				}
			}
			i++;
		}
		return result;
	}
	
}
