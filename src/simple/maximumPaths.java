package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class maximumPaths {
	public static void main(String[] args) {
		maximumPaths maximumPathsOb = new maximumPaths();
		
		List<List<Integer>> matrix = new ArrayList<>();
		
		
		matrix.add(Arrays.asList(0,0,1,0,1));
		matrix.add(Arrays.asList(0,0,0,0,1));
		matrix.add(Arrays.asList(0,0,1,0,0));
		matrix.add(Arrays.asList(0,0,1,0,0));
		
		//memorization
		Map<matrixIndex, Integer> lookup = new HashMap<>();
		
		
		int i=0;
		int j=0;
		int result= maximumPathsOb.paths(matrix,i,j,lookup);
		System.out.println(result);
			
		
	}
	
	public class matrixIndex {
		private int i;
		private int j;		
		
		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}
		
		public matrixIndex(int i,int j) {
			this.i=i;
			this.j=j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i + j; 
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
			matrixIndex other = (matrixIndex) obj;
			return i == other.i && j == other.j;
		}
		
		
		
	}

	private int paths(List<List<Integer>> matrix, int i, int j, Map<matrixIndex, Integer> lookup) {
		int n = matrix.size();
		int m = matrix.get(0).size();
		
		
		matrixIndex matrixInd = new matrixIndex(i, j);
		
		//dynamic programming loop up
		if(lookup.containsKey(matrixInd)) {
			return lookup.get(matrixInd);
		}
		
		//first base case - failure case 
		//we are out of row or column, and if we at last row then same.
		if(i==n || j==m || matrix.get(i).get(j) == 1) {
			return 0;
		}
		
		//second base case - success case
		// if i and j point to destination cell then return 1
		else if((n-1)==i && (m-1)==j) {
			return 1;
		}
		
		//recursive call
		else {
			lookup.put(matrixInd, paths(matrix, i+1,j,lookup) + paths(matrix, i,j+1,lookup));
			return lookup.get(matrixInd);
		}
	}
}
