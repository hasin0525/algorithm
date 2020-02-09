class Solution {
	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= num; i++) {
			dp[i] = dp[i / 2] + dp[i % 2];
		}
		return dp;
	}
}