class Solution {
	boolean[][] visited;
	int answer = Integer.MIN_VALUE, rMax, cMax;
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };

	public int getMaximumGold(int[][] grid) {
		rMax = grid.length;
		cMax = grid[0].length;
		visited = new boolean[rMax][cMax];

		for (int i = 0; i < rMax; i++) {
			for (int j = 0; j < cMax; j++) {
				if (grid[i][j] != 0) {
					dfs(i, j, grid[i][j], grid);
				}
			}
		}
		return answer;
	}
    //backtracking
	private void dfs(int r, int c, int sum, int[][] grid) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= 0 && nextR < rMax && nextC >= 0 && nextC < cMax && !visited[nextR][nextC]
					&& grid[nextR][nextC] != 0) {
				dfs(nextR,nextC,sum+grid[nextR][nextC],grid);
			}
		}
		visited[r][c] = false;
		answer = Math.max(answer, sum);
	}
}