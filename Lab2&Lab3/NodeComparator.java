package Lab2;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if((o1.getPathCost() - o2.getPathCost()) > 0) {
			return (int) o1.getPathCost();
		}else if(o1.getPathCost() - o2.getPathCost() == 0) {
			return o1.getLabel().compareToIgnoreCase(o2.getLabel());
		}else {
			return (int) o2.getPathCost();
		}

	}

}
