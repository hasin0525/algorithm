import java.util.Arrays;

class Solution {
	public int singleNumber(int[] nums) {
		Integer answer = null;
		Arrays.parallelSort(nums);
		for (int i = 0; i < nums.length - 1; i+=2) {
			if(nums[i] != nums[i+1]) {
				answer = nums[i];
				break;
			}
		}
		if(answer == null) answer = nums[nums.length-1];
		return answer;
	}
}