class Solution {
	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}