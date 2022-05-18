package simple;

import java.util.HashMap;
import java.util.Map;

public class LcsOfString {
	public static void main(String[] args) {
		LcsOfString lcsOfString = new LcsOfString();
		
		String s1 = "abdacbab";
		String s2 = "acebfca";
		
		int i=0;
		int j=0;
		
		int result = lcsOfString.findLCSrecursive(s1,s2,i,j);
		System.out.println(result);
		
		/* Test Case 2 */
		Map<LookupClass, Integer> lookup = new HashMap<>();
		int resultDynamic = lcsOfString.findLCSdynamic(s1, s2, i, j, lookup);
		System.out.println(resultDynamic);
		
		
		
	}
	
	protected class LookupClass {
		int i;
		int j;

		public LookupClass(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LookupClass other = (LookupClass) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

		public int getI() {
			return i;
		}
		
		public int getJ() {
			return j;
		}
		
		
		
	}
	

	private int findLCSrecursive(String s1, String s2, int i, int j) {
		if(i == s1.length() || j==s2.length()) {
			return 0;
		}
		else if(s1.charAt(i) == s2.charAt(j)) {
			return 1+findLCSrecursive(s1, s2, i+1, j+1);
		} else {
			return Math.max(findLCSrecursive(s1, s2, i+1, j), findLCSrecursive(s1, s2, i, j+1));
		}
	}
	
	private int findLCSdynamic(String s1, String s2, int i, int j, Map<LookupClass, Integer> lookup ) {
		
		LookupClass tempOb = new LookupClass(i,j);
		if(lookup.containsKey(tempOb)) {
			return lookup.get(tempOb);
		}
		
		if(i == s1.length() || j==s2.length()) {
			return 0;
		}
		else if(s1.charAt(i) == s2.charAt(j)) {
			int resultTemp = 1+findLCSdynamic(s1, s2, i+1, j+1, lookup);
			lookup.put(tempOb, resultTemp);
			return resultTemp;
		} else {
			int resultTemp = Math.max(findLCSrecursive(s1, s2, i+1, j), findLCSrecursive(s1, s2, i, j+1));
			lookup.put(tempOb, resultTemp);
			return resultTemp;
		}
	}
}
