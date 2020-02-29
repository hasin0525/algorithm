class Solution {
	public boolean solution(int x) {
		int originValue = x;
		int digitSum = 0;
		while (x != 0) {
			digitSum += x % 10;
			x /= 10;
		}

		if (originValue % digitSum == 0) {
			return true;
		}
		return false;
	}
}