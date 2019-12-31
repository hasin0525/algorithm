class Solution {
    public int[] diStringMatch(String S) {
        int low = 0, high = S.length(), n = S.length();
        int[] answer = new int[n+1];
        
        for(int i = 0; i < n;i++) {
        	if(S.charAt(i)=='I') {
        		answer[i] = low++;
        	}else {
        		answer[i] = high--;
        	}
        }
        answer[n] = low;
        return answer;
    }
}