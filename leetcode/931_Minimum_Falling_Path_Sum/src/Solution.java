class Solution {
    public int minFallingPathSum(int[][] A) {
    	int[][] dp = new int[A.length][A.length];
    	for(int i = 0; i < A.length; i++) {
    		dp[0][i] = A[0][i];
    	}
    	for(int i = 1; i < A.length; i++) {
    		for(int j = 0; j < A.length; j++) {
    			dp[i][j] = dp[i-1][j];
    			if(j-1 >= 0) {
    				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
    			}
    			if(j+1 < A.length) {
    				dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
    			}
    			dp[i][j] += A[i][j];
    		}
    	}
    	int answer = Integer.MAX_VALUE;
    	for(int i = 0; i < A.length; i++) {
    		answer = Math.min(answer, dp[A.length-1][i]);
    	}
    	return answer;
    }
}