import java.util.Arrays;

class Solution {
	public int solution(int[] weight) {
		int sum = 1;
		Arrays.sort(weight);
		for (int i : weight) {
			if (sum < i) {
				break;
			} else {
				sum += i;
			}
		}
		return sum;
	}
}