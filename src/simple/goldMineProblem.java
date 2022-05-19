package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class goldMineProblem {
	public static void main(String[] args) {
		goldMineProblem goldMineProblemOb = new goldMineProblem();
		
		List<List<Integer>> mineList = new ArrayList<>();
		
		mineList.add(Arrays.asList(3,2,12,15,10));
		mineList.add(Arrays.asList(6,19,7,11,17));
		mineList.add(Arrays.asList(8,5,12,32,21));
		mineList.add(Arrays.asList(3,20,2,9,7));
		
		int i = 0;
		int j = 0;
		int result = goldMineProblemOb.robRecursiveAllEntry(mineList);
		System.out.println(result);
		
		
		// calling the top down approach with tabulation
		int resultTable = goldMineProblemOb.robUsingTable(mineList);
		System.out.println(resultTable);
		
		
	}
	
	
	private int robUsingTable(List<List<Integer>> mineList) {
		int n = mineList.size();
		int m = mineList.get(0).size();
		
		int[][] table = new int[n][m];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(i<0 || j<0 || i>=n || j>=m ) {
					continue;
				}
				else if(i==0) {
					table[i][j] = mineList.get(i).get(j);
				} 
				else if(j==0) {
					table[i][j] = mineList.get(i).get(j) + Math.max(table[i-1][j], table[i-1][j+1]);
				} else if(j==m-1) {
					table[i][j] = mineList.get(i).get(j) + Math.max(table[i-1][j-1], table[i-1][j]);
				}
				else {
					table[i][j] = mineList.get(i).get(j) + Math.max(table[i-1][j-1], 
							Math.max(table[i-1][j], table[i-1][j+1]));
				}
				
			}
		}
		
		//returing max value from last row
		int result = 0;
		for(int i=0;i<m;i++) {
			result = Math.max(result, table[n-1][i]);
		}
		
		return result;
	}


	private class twoKeyDataStructure {
		int i;
		int j;
		
		public twoKeyDataStructure(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(i, j);
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
			twoKeyDataStructure other = (twoKeyDataStructure) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return i == other.i && j == other.j;
		}
		
		public int getI() {
			return i;
		}
		public int getJ() {
			return j;
		}
		private goldMineProblem getEnclosingInstance() {
			return goldMineProblem.this;
		}
		
		
		
	}
	

	private int robRecursiveAllEntry(List<List<Integer>> mineList) {
		int maxGold = 0;
		int m = mineList.get(0).size();
		int n = mineList.size();
		
		Map<twoKeyDataStructure, Integer> lookup = new HashMap<>();
		
		for(int k=0;k<n;k++) {
			maxGold = Math.max(maxGold, robRecursive(mineList, 0, k, lookup));
		}
		
		return maxGold;
	}

	private int robRecursive(List<List<Integer>> mineList, int i, int j, Map<twoKeyDataStructure, Integer> lookup) {
		int m = mineList.get(0).size();
		int n = mineList.size();
		
		//dynamic lookup for storing result of already calculated results.
		twoKeyDataStructure tempOb = new twoKeyDataStructure(i, j);
		if(lookup.containsKey(tempOb)) {
			return lookup.get(tempOb);
		}
		
		
		//base case
		if(i<0 || i>=n || j<0 || j>=m) {
			return 0;
		}
		
		else { 
			int tempResult = mineList.get(i).get(j) + Math.max(robRecursive(mineList, i+1, j-1, lookup), 
					Math.max(robRecursive(mineList, i+1, j, lookup), robRecursive(mineList, i+1, j+1, lookup))); 
			lookup.put(tempOb, tempResult);
			return tempResult;
		}
		
	}
}
