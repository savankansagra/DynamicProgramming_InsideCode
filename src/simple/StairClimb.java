package simple;

public class StairClimb {
	public static void main(String[] args) {
		StairClimb stairClimb = new StairClimb();
		
		System.out.println(stairClimb.totalSteps(5));
	}

	private int totalSteps(int n) {
		if(n==0) {
			return 1;
		} else if(n<0) {
			return 0;
		} else {
			return totalSteps(n-1)+totalSteps(n-2)+totalSteps(n-3);
		}
		
	}
}
