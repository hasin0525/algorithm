class Solution {
	int S, answer;
	int[] nums;
    public int findTargetSumWays(int[] nums, int S) {
    	this.nums = nums;
    	this.S = S;
        combination(0, 0);
        return answer;
    }
	private void combination(int index, int sum) {
		if(index == nums.length) {
			if(sum == S) answer++;
			return;
		}
        combination(index+1, sum + nums[index]);
        combination(index+1, sum - nums[index]);
	}
}