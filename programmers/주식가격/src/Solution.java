class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = prices.length - 1; i >= 0; i--) {
			answer[i] = (prices.length - 1) - i;
			for(int j = i +1; j < prices.length; j++) {
				if(prices[j] < prices[i]) {
					answer[i] = j -i;
					break;
				}
			}
		}
		
		return answer;
	}
}