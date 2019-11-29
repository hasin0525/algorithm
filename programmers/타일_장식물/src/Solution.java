class Solution {
	public long solution(int N) {
		long[] dp = new long[N + 1];
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return 2 * dp[N] + 2 * (dp[N] + dp[N-1]);
	}
}