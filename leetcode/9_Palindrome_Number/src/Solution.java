class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
        	return false;
        }
        if(x == 0) {
        	return true;
        }
        int[] nums = new int[(int) (Math.log10(x)+1)];
        int index = 0;
        while(x != 0) {
        	nums[index++]= x % 10;
        	x /= 10;
        }
        for(int i = 0; i < nums.length / 2; i++) {
        	if(nums[i] != nums[nums.length -1 - i]) {
        		return false;
        	}
        }
        return true;
    }
}