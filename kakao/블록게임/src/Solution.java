class Solution {
	int count = 0;
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };

	public void deleteBlock(int r, int c, int num, int[][] board) {
		board[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board.length) {
				if (board[nextR][nextC] == num) {
					deleteBlock(nextR, nextC, num, board);
				}
			}
		}
	}

	public void insertBlock(int r1, int c1, int r2, int c2, int num, int[][] board) {
		if (!(board[r1][c1] == 0 && board[r2][c2] == 0)) {
			return;
		}
		for (int i = r1 - 1; i >= 0; i--) {
			if (board[i][c1] > 0) {
				return;
			}
		}
		for (int i = r2 - 1; i >= 0; i--) {
			if (board[i][c2] > 0) {
				return;
			}
		}
		board[r1][c1] = num;
		board[r2][c2] = num;
		deleteBlock(r1, c1, num, board);
		count++;
	}

	public void getShape(int row, int col, int[][] board) {
		if (row + 1 < board.length && row + 2 < board.length && col - 1 >= 0) {
			if (board[row + 1][col] == board[row][col] && board[row + 2][col] == board[row][col]
					&& board[row + 2][col - 1] == board[row][col]) {
				insertBlock(row + 1, col - 1, row, col - 1, board[row][col], board);
				return;
			}
		}

		if (row + 1 < board.length && row + 2 < board.length && col + 1 < board.length) {
			if (board[row + 1][col] == board[row][col] && board[row + 2][col] == board[row][col]
					&& board[row + 2][col + 1] == board[row][col]) {
				insertBlock(row + 1, col + 1, row, col + 1, board[row][col], board);
				return;
			}
		}

		if (row + 1 < board.length && col - 1 >= 0 && col - 2 >= 0) {
			if (board[row + 1][col] == board[row][col] && board[row + 1][col - 1] == board[row][col]
					&& board[row + 1][col - 2] == board[row][col]) {
				insertBlock(row, col - 1, row, col - 2, board[row][col], board);
				return;
			}
		}

		if (row + 1 < board.length && col + 1 < board.length && col + 2 < board.length) {
			if (board[row + 1][col] == board[row][col] && board[row + 1][col + 1] == board[row][col]
					&& board[row + 1][col + 2] == board[row][col]) {
				insertBlock(row, col + 1, row, col + 2, board[row][col], board);
				return;
			}
		}

		if (row + 1 < board.length && col - 1 >= 0 && col + 1 < board.length) {
			if (board[row + 1][col] == board[row][col] && board[row + 1][col - 1] == board[row][col]
					&& board[row + 1][col + 1] == board[row][col]) {
				insertBlock(row, col - 1, row, col + 1, board[row][col], board);
				return;
			}
		}
	}

	public int solution(int[][] board) {

		while(true) {
			int init = count;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] > 0) {
						getShape(i, j, board);
					}
				}
			}
			if(init == count) {
				break;
			}
		}
		
		return count;
	}
}