class Solution {
    public int countSquares(int[][] matrix) {
        int rMax = matrix.length;
        int cMax = matrix[0].length;
        int[][] dp = new int[rMax+1][cMax+1];
        for(int i = 1; i <= rMax; i++) {
        	for(int j = 1; j <= cMax; j++) {
        		if(matrix[i-1][j-1]==1) {
        			dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
        		}
        	}
        }
        return dp[rMax][cMax];
    }
}