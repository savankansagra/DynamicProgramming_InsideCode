package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WayToClimb {
	public static void main(String[] args) {
		WayToClimb wayToClimb = new WayToClimb();
		List<Integer> waysList = (List<Integer>) Arrays.asList(2,4,5,8);
		int n=10;
		
		int result = wayToClimb.ways(n, waysList);
		System.out.println(result);
		
		//-- dynamic way
		Map<Integer, Integer> lookup = new HashMap<>();
		int resultDynamic = wayToClimb.waysDynamic(n, waysList, lookup);
		System.out.println(resultDynamic);
		
	}

	private int waysDynamic(int n, List<Integer> waysList, Map<Integer, Integer> lookup) {
		if(lookup.containsKey(n)) {
			return lookup.get(n);
		}
		if(n==0) {
			return 1;
		} else if(n<0){
			return 0;
		}
		else {
			int nb=0;
			for(int jump:waysList) {
				nb+= ways(n-jump, waysList);
			}
			lookup.put(n, nb);
			return nb;
		}
	}

	private int ways(int n, List<Integer> waysList) {
		if(n==0) {
			return 1;
		} else if(n<0){
			return 0;
		}
		else {
			int nb=0;
			for(int jump:waysList) {
				nb+= ways(n-jump, waysList);
			}
			return nb;
		}
	}
}
