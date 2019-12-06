class Solution {
	public boolean isSubsequence(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		int index = 0;
		for (int i = 0; i < tArr.length; i++) {
			if (index >= sArr.length) {
				break;
			}
			if (tArr[i]== sArr[index]) {
				index += 1;
			}
		}
		if (index == sArr.length) {
			return true;
		} else {
			return false;
		}
	}
}