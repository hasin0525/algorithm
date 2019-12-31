class Solution {
    public int maxProfit(int[] prices) {
    	int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			answer = Math.max(answer, prices[i] - min);
		}
        return answer;
    }
}