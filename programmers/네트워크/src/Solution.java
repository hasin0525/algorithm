class Solution {
	private int answer = 0;
	private boolean[][] visited;
	private int[][] copyComputers;
	private int max;
	private void dfs(int cur, int next) {
		visited[cur][next] = true;
		visited[next][cur] = true;
		for(int i = 0; i < max; i++) {
			if(cur != i && copyComputers[cur][i] == 1 && !visited[cur][i] && !visited[i][cur]) {
				visited[cur][i] = true;
				visited[i][cur] = true;
				dfs(i,0);
			}
		}
	}
	
	public int solution(int n, int[][] computers) {
    	copyComputers= computers;
    	max = n;
    	visited = new boolean[n][n];
    	for(int i  = 0; i < n; i++) {
    		if(!visited[i][0]) {
        		dfs(i,0);
        		answer += 1;
    		}
    	}
    	
        return answer;
    }
}