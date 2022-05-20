package simple;

public class KnapSack0_1 {
	public static void main(String[] args) {
		KnapSack0_1 knapSack0_1 = new KnapSack0_1();
		
		int[] values = new int[] {20, 30, 15, 25, 10};
		int[] weight = new int[] {6,13,5,10,3};
		int k=20;
		int i=0;
		
		int result = knapSack0_1.knapSack(values, weight, k, i);
		System.out.println(result);
	}

	private int knapSack(int[] values, int[] weight, int k, int i) {
		if(i == values.length) {
			return 0;
		} else if(weight[i] > k) {
			return knapSack(values, weight, k, i+1);
		}
		else {
			return Math.max(values[i] + knapSack(values, weight, k-weight[i], i+1), knapSack(values, weight, k, i+1));
		}
	}
}
