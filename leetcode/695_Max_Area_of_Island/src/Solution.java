class Solution {
	int answer = 0;
	int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};
    int rMax, cMax;
    boolean[][] visited;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
    	this.grid = grid;
        rMax = grid.length;
        cMax = grid[0].length;
        visited = new boolean[rMax][cMax];
        
        for(int i = 0; i < rMax; i++) {
        	for(int j = 0; j < cMax; j++) {
        		if(!visited[i][j] && grid[i][j] == 1) {
        			answer = Math.max(answer, dfs(i,j) + 1);
        		}
        	}
        }
        
        return answer;
    }
	private int dfs(int r, int c) {
		int area = 0;
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if(nextR >= 0 && nextR < rMax && nextC >= 0 && nextC < cMax && !visited[nextR][nextC] && grid[nextR][nextC] == 1) {
				area += 1;
				area += dfs(nextR,nextC);
			}
		}
		return area;
	}
}