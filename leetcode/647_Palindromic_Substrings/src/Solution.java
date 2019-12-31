class Solution {
	public int countSubstrings(String s) {
		char[] chars = s.toCharArray();
		int palindrom = chars.length;

		for (int length = 2; length <= chars.length; length++) {
			for (int start = 0; start <= chars.length - length; start++) {
				if (isPalindrom(chars, start, start + length-1)) {
					palindrom++;
				}
			}
		}

		return palindrom;
	}

	private boolean isPalindrom(char[] chars, int start, int end) {
		int mid = (start + end) / 2;
		while (start <= mid) {
			if (chars[start++] != chars[end--]) {
				return false;
			}
		}
		return true;
	}
}