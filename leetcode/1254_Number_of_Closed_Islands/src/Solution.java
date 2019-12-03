class Solution {
	int rMax;
	int cMax;
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };

	public int closedIsland(int[][] grid) {
		int answer = 0;
		rMax = grid.length;
		cMax = grid[0].length;
		for (int r = 0; r < rMax; r++) {
			for (int c = 0; c < cMax; c++) {
				if (grid[r][c] == 0) {
					if (dfs(r, c, grid)) {
						answer += 1;
					}
				}
			}
		}
		return answer;
	}

	private boolean dfs(int r, int c, int[][] grid) {
		if (r < 0 || r >= rMax || c < 0 || c >= cMax) {
			return false;
		}
		if (grid[r][c] == 1) {
			return true;
		}
		grid[r][c] = 1;
		boolean isClosed = true;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			isClosed = isClosed & dfs(nextR, nextC, grid);
		}
		return isClosed;
	}
}