class Solution {
	public int solution(int[] left, int[] right) {
		int[][] dp = new int[left.length][right.length];

		dp[0][0] = (left[0] > right[0]) ? right[0] : 0;
		for (int j = 1; j < right.length; j++) {
			dp[0][j] = (left[0] > right[j] && left[0] > right[j - 1]) ? right[j] + dp[0][j - 1] : dp[0][j - 1];
		}

		for (int i = 1; i < left.length; i++) {
			for (int j = 1; j < right.length; j++) {
				dp[i][j] = (left[i] > right[j - 1])
						? Math.max(dp[i][j - 1] + right[j - 1], Math.max(dp[i - 1][j - 1], dp[i - 1][j]))
						: Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		return (left[left.length - 1] > right[right.length - 1])
				? dp[left.length - 1][right.length - 1] + right[right.length - 1]
				: dp[left.length - 1][right.length - 1];
	}
}