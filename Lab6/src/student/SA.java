package student;

public class SA {
	public Node execute(Node intalState) {
		Node current = intalState;
		Node next = null;
		int T = 1000;
		while(current.getH() != 0) {
			next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - current.getH();
			if(deltaE < 0) {
				current = next;
			}else {
				if(Math.exp(deltaE/T) < Math.PI) {
					current = next;
				}
			}
		}
		
		return current;
	}
}
