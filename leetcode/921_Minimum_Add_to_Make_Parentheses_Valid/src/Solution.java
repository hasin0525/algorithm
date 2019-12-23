class Solution {
	public int minAddToMakeValid(String S) {

		int l = 0;
		int r = 0;
		for (int i = 0, length = S.length(); i < length; i++) {
			if (S.charAt(i) == '(') {
				l++;
			}else if(l > 0) {
				l--;
			}else {
				r++;
			}
		}
		return l+r;
	}
}