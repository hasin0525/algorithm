class Solution {
	int[] sum;
	int[][] dp;
    public int stoneGameII(int[] piles) {
    	sum = new int[piles.length];
    	sum[piles.length-1] = piles[piles.length-1];
    	for(int i = piles.length-2; i >= 0; i--) {
    		sum[i] = sum[i+1] + piles[i];
    	}
    	
    	dp = new int[piles.length][33];
    	return dynamic(piles, 0,1);
    }
    
    public int dynamic(int[] piles, int i, int M) {
    	if(piles.length == i) {
    		return 0;
    	}
    	if(2*M >= piles.length - i) {
    		return sum[i];
    	}
    	if(dp[i][M] != 0){
            return dp[i][M];
        }
        
    	int min = Integer.MAX_VALUE;
    	for(int x = 1; x <= 2*M; x++) {
    		min = Math.min(min, dynamic(piles, i+x, Math.max(M, x)));
    	}
    	dp[i][M] = sum[i] - min;
    	return dp[i][M];
    }
}