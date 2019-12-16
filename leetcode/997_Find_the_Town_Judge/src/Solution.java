class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N+1];
        boolean[] isTrust = new boolean[N+1];
        for(int i = 0; i < trust.length; i++) {
        	trustCount[trust[i][1]]+=1;
        	isTrust[trust[i][0]] = true;
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
        	if(trustCount[i] == N-1 && !isTrust[i]) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
}