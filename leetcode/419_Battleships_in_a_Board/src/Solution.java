class Solution {
	int[] dr = { 0, 0, 0, -1, 1 };
	int[] dc = { 0, -1, 1, 0, 0 };
	boolean[][] visited;

	boolean dfs(int r, int c, int d, char[][] board) {
		boolean check = true;
		visited[r][c] = true;
		int nextR = r;
		int nextC = c;
		for (int i = 1; i <= 4; i++) {
			nextR = r + dr[i];
			nextC = c + dc[i];
			if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board[0].length && !visited[nextR][nextC]
					&& board[nextR][nextC] == 'X') {
				if (d != 0 && d != i) {
					check = false;
				}
				check &= dfs(nextR, nextC, i, board);
			}
		}
		return check;
	}

	public int countBattleships(char[][] board) {
		int count = 0;
		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!visited[i][j] && board[i][j] == 'X' && dfs(i, j, 0, board)) {
					count += 1;
				}
			}
		}
		return count;
	}
}