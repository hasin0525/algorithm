class Solution {
    public int balancedStringSplit(String s) {
    	int answer = 0;
        int l = 0;
        int r = 0;
        for (int i = 0, length = s.length(); i < length; i ++) {
        	if(s.charAt(i) == 'L') {
        		l++;
        	}else {
        		r++;
        	}
        	if(l==r) {
        		l = 0;
        		r = 0;
        		answer++;
        	}
        }
        return answer;
    }
}