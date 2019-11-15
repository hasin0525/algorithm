import java.util.HashSet;
import java.util.Set;

class Solution {
	char[] numbers;
	Set<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		this.numbers = numbers.toCharArray();

		for (int i = 1; i <= this.numbers.length; i++) {
			boolean[] select = new boolean[this.numbers.length];
			makePermutation(0, i, select, new StringBuilder());
		}

		return set.size();
	}

	private boolean isPrime(int input) {
		if(input == 1 || input == 0) {
			return false;
		}
		for (int i = 2; i <= input / 2; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}

	private void makePermutation(int count, int max, boolean[] select, StringBuilder sb) {
		if (count == max) {
			int input = Integer.parseInt(sb.toString());
			if(isPrime(input)) {
				set.add(input);
			}
			return;
		}
		for (int i = 0; i < select.length; i++) {
			if (!select[i]) {
				select[i] = true;
				sb.append(numbers[i]);
				makePermutation(count + 1, max, select, sb);
				sb.deleteCharAt(sb.length() - 1);
				select[i] = false;
			}
		}
	}

}