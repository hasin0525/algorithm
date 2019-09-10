class Solution {
	public boolean checkPossibility(int[] nums) {
		// 배열의 값을 한개를 바꿔서 오름차순 배열을 만들 수 있나?
		if (nums.length == 1) {
			return true;
		}
		boolean change = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if(change) {
					return false;
				}
				if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
					nums[i + 1] = nums[i];
					change = true;
				} else {
					nums[i] = nums[i+1] -1;
					change = true;
				}
				if(!change) {
					return false;
				}
			}
		}
		
		return true;
	}
}