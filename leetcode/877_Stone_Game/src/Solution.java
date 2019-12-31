class Solution {
    public boolean stoneGame(int[] piles) {
        int length = piles.length / 2;
        int[] dp = new int[length];
        
        return go(dp,0,piles.length-1,piles);
    }

	private boolean go(int[] dp, int start, int end, int[] piles) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}
}