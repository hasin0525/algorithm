import java.util.Arrays;

class Solution {
	public int majorityElement(int[] nums) {
		Arrays.parallelSort(nums);
		int count = (int)Math.ceil(nums.length / 2.0);
		int c = 1;
		int answer = nums[0];
		for (int i = 0, length = nums.length - 1; i < length; i++) {
			if (nums[i] == nums[i + 1]) {
				c++;
			} else {
				c = 1;
			}
			if (c >= count) {
				answer = nums[i];
				break;
			}
		}
		return answer;
	}
}