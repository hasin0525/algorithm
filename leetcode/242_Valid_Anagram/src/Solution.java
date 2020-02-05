class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] usedAlphabet = new int[26];
		for (char alphabet : s.toCharArray()) {
			usedAlphabet[alphabet - 'a']++;
		}
		for (char alphabet : t.toCharArray()) {
			if (--usedAlphabet[alphabet - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] usedAlphabet = new int[26];
		for (char alphabet : s.toCharArray()) {
			usedAlphabet[alphabet - 97]++;
		}
		for (char alphabet : t.toCharArray()) {
			if (--usedAlphabet[alphabet - 97] < 0) {
				return false;
			}
		}
		return true;
	}
}