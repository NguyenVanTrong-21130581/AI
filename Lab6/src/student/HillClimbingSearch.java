package student;

public class HillClimbingSearch {
	public Node execute(Node intalState) {
		Node current = intalState;
		Node neighor = null;
		while(true) {
			neighor = current.getBestCandidates();
			if(neighor.getH() != 0) {
				current = neighor.selectNextRandomCandidate();
			}else {
				return current;
			}
		}
	}
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
			// Enter your code here.
			return null;
			}
}
