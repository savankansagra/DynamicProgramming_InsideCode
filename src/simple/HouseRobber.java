package simple;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HouseRobber {
	public static void main(String[] args) {
		HouseRobber houseRobber = new HouseRobber();
		
		ArrayList<Integer> arr = new ArrayList<>();
		int i=0;
		arr.addAll(Arrays.asList(4,10,5,2,3,7));
		
		//int total = houseRobber.rob(arr, i);
		HashMap<Integer, Integer> lookup = new HashMap<>();
		
		int totalDyna = houseRobber.robDyna(arr,i,lookup);
		
		System.out.println(totalDyna);
		
		//top down approach test case
		int tpdAns = houseRobber.topDownRob(arr);
		System.out.println(tpdAns);
		
	}

	private int robDyna(ArrayList<Integer> arr, int i, HashMap<Integer, Integer> lookup) {
		if(lookup.containsKey(i)) return lookup.get(i);
			
		if(i >= arr.size()) {
			return 0;
		} else {
			int total = Math.max(arr.get(i)+rob(arr, i+2), rob(arr, i+1));
			lookup.put(i, total);
			return total;
		}
	}

	private int rob(ArrayList<Integer> arr, int i) {
		if(i >= arr.size()) {
			return 0;
		} else {
			return Math.max(arr.get(i)+rob(arr,i+2), rob(arr,i+1));
		}
		
	}
	
	private int topDownRob(ArrayList<Integer> arr) {
		
		ArrayList<Integer> dptd = new ArrayList<>();
		
		if(arr.size()>=2) {
			dptd.add(arr.get(0));
			dptd.add(Math.max(dptd.get(0), arr.get(1)));
		}
		
		for(int j=2;j<arr.size();j++) {
			int total = Math.max(arr.get(j)+dptd.get(j-2) , dptd.get(j-1));
			dptd.add(total);
		}
		
		return dptd.get(arr.size()-1);
	}
}
