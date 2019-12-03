import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		return makeHappy(n, set);
	}

	private boolean makeHappy(int n, Set<Integer> set) {
		if (n == 1) {
			return true;
		}
		int sum = 0;
		while (n != 0) {
			int temp = n % 10;
			n /= 10;
			sum += Math.pow(temp, 2);
		}
		if (set.contains(sum)) {
			return false;
		} else {
			set.add(sum);
			return makeHappy(sum, set);
		}
	}
}