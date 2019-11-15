class Solution {
	public int solution(String arrangement) {
		int sum = 0;
		int bar = 0;
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				bar++;
			} else if (arrangement.charAt(i - 1) == ')') {
				//))
				bar--;
				sum++;
			} else {
				//()
				bar--;
				sum += bar;
			}
		}

		return sum;
	}
}