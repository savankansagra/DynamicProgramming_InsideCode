package simple;

public class EditDistance {
	public static void main(String[] args) {
		EditDistance editDistance = new EditDistance();
		
		String s1 = "inside";
		String s2 = "index";
		
		int i=0;
		int j=0;
		
		int minDistance = editDistance.distRecursive(s1,s2,i,j);
		System.out.println(minDistance);
		
	}

	private int distRecursive(String s1, String s2, int i, int j) {
		if(i == s1.length()-1) {
			return s2.length()-j-1;
		} else if(j == s2.length()-1) {
			return s1.length()-i-1;
		} else if(s1.charAt(i) == s2.charAt(j)) {
			return distRecursive(s1, s2, i+1, j+1);
		} else {
			return 1+ Math.min(distRecursive(s1, s2, i+1, j),
					Math.min(distRecursive(s1, s2, i, j+1), 
							distRecursive(s1, s2, i+1, j+1)));
		}	
	}
}
