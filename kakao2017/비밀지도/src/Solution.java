class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		int maxValue = 0;
		for (int i = 0; i < n; i++) {
			maxValue = Math.max(maxValue, Math.max(arr1[i], arr2[i]));
		}
		int max = Integer.toBinaryString(maxValue).length();
		String[] answer = new String[n];
		
		for (int i = 0; i < n; i++) {
			String a = Integer.toBinaryString(arr1[i]);
			String b = Integer.toBinaryString(arr2[i]);
			if (max > a.length()) {
				int count = max - a.length();
				for (int j = 0; j < count; j++) {
					a = "0".concat(a);
				}
			}
			if (max > b.length()) {
				int count = max - b.length();
				for (int j = 0; j < count; j++) {
					b = "0".concat(b);
				}
			}
			
			String input = "";
			for (int j = 0; j < max; j++) {
				if (a.charAt(j) == b.charAt(j)) {
					if (a.charAt(j) == '1') {
						input = input.concat("#");
					} else {
						input = input.concat(" ");
					}
				} else {
					input = input.concat("#");
				}
			}
			answer[i] = input;
		}
		return answer;
		
	}
}