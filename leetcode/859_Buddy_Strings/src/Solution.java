class Solution {
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length() || A.length() == 0 || B.length() == 0) {
			return false;
		}
        
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        }
        
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		char[] lettersByA = new char[2];
		char[] lettersByB = new char[2];
		int lettersByAIndex = 0;
		int lettersByBIndex = 0;
		int differ = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
                if(differ++ >= 2){
                    return false;
                }
				lettersByA[lettersByAIndex++] = a[i];
				lettersByB[lettersByBIndex++] = b[i];
			}
		}

		if(differ != 2) {
			return false;
		}
		
		if(lettersByA[1] != lettersByB[0] || lettersByA[0] != lettersByB[1]) {
			return false;
		}
		
		return true;
	}
}