class Solution {
	int[] dr = { 0, 0, -1, 1, -1, 1, 1, -1 };
	int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };
	boolean[][] visited;
	
	public void e(int r, int c, char[][] board) {
		visited[r][c] = true;
		char mine = '0';
		int rMax = board.length;
		int cMax = board[0].length;
		for (int i = 0; i < 8; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= 0 && nextC >= 0 && nextR < rMax && nextC < cMax && board[nextR][nextC] == 'M') {
				mine += 1;
			}
		}
		if (mine != '0') {
			board[r][c] = mine;
		} else {
			board[r][c] = 'B';
			for (int i = 0; i < 8; i++) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				if (nextR >= 0 && nextC >= 0 && nextR < rMax && nextC < cMax && !visited[nextR][nextC]) {
					e(nextR, nextC, board);
				}
			}
		}
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		visited = new boolean[board.length][board[0].length];
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		} else {
			e(click[0], click[1], board);
		}
		return board;
	}
}