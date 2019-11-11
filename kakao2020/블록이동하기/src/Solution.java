import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Robot {
		int r1, c1, r2, c2, d;

		public Robot(int r1, int c1, int r2, int c2, int d) {
			super();
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.d = d;
		}
	}

	boolean[][][][] visited;
	int n, answer = Integer.MAX_VALUE;
	int[][] board;
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };
	Queue<Robot> q;

	public int solution(int[][] board) {
		this.board = board;
		n = board.length;
		visited = new boolean[n][n][n][n];
		visited[0][0][0][1] = true;
		q = new LinkedList<>();
		q.add(new Robot(0, 0, 0, 1, 0));
		bfs();
		return answer;
	}

	private void bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Robot r = q.poll();
				// 여기서 결승선에 닿았는지 확인한다.
				if ((r.r1 == n - 1 && r.c1 == n - 1) || (r.r2 == n - 1 && r.c2 == n - 1)) {
					answer = Math.min(answer, time);
					return;
				}
				for (int j = 0; j < 5; j++) {
					if (j == 4) {
						// 회전
						if (r.d == 0) {
							// 가로
							// 1이 왼쪽에 있음
							if (r.c1 < r.c2) {
								// 위쪽으로
								if (r.r1 - 1 >= 0 && r.r2 - 1 >= 0 && board[r.r1 - 1][r.c1] != 1
										&& board[r.r2 - 1][r.c2] != 1) {
									visited[r.r1 - 1][r.c1 + 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 - 1, r.c1 + 1, r.r2, r.c2, 1));
									visited[r.r1][r.c1][r.r2 - 1][r.c2 - 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 - 1, r.c2 - 1, 1));
								}
								// 아래로
								if (r.r1 + 1 < n && r.r2 + 1 < n && board[r.r1 + 1][r.c1] != 1
										&& board[r.r2 + 1][r.c2] != 1) {
									visited[r.r1][r.c1][r.r2 + 1][r.c2 - 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 + 1, r.c2 - 1, 1));
									visited[r.r1 + 1][r.c1 + 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 + 1, r.c1 + 1, r.r2, r.c2, 1));
								}
							} else {
								// 1이 오른쪽에 있음
								// 위쪽으로
								if (r.r1 - 1 >= 0 && r.r2 - 1 >= 0 && board[r.r1 - 1][r.c1] != 1
										&& board[r.r2 - 1][r.c2] != 1) {
									visited[r.r1][r.c1][r.r2 - 1][r.c2 + 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 - 1, r.c2 + 1, 1));
									visited[r.r1 - 1][r.c1 - 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 - 1, r.c1 - 1, r.r2, r.c2, 1));
								}
								// 아래로
								if (r.r1 + 1 < n && r.r2 + 1 < n && board[r.r1 + 1][r.c1] != 1
										&& board[r.r2 + 1][r.c2] != 1) {
									visited[r.r1 + 1][r.c1 - 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 + 1, r.c1 - 1, r.r2, r.c2, 1));
									visited[r.r1][r.c1][r.r2 + 1][r.c2 + 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 + 1, r.c2 + 1, 1));
								}
							}
						} else {
							// 세로
							if (r.r1 < r.r2) {
								// 왼쪽으로
								if (r.c1 - 1 >= 0 && r.c2 - 1 >= 0 && board[r.r1][r.c1 - 1] != 1
										&& board[r.r2][r.c2 - 1] != 1) {
									visited[r.r1][r.c1][r.r2 - 1][r.c2 - 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 - 1, r.c2 - 1, 0));
									visited[r.r1 + 1][r.c1 - 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 + 1, r.c1 - 1, r.r2, r.c2, 0));
								}
								// 오른쪽으로
								if (r.c1 + 1 < n && r.c2 + 1 < n && board[r.r1][r.c1 + 1] != 1
										&& board[r.r2][r.c2 + 1] != 1) {
									visited[r.r1][r.c1][r.r2 - 1][r.c2 + 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 - 1, r.c2 + 1, 0));
									visited[r.r1 + 1][r.c1 + 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 + 1, r.c1 + 1, r.r2, r.c2, 0));
								}
							} else {
								// 왼쪽으로
								if (r.c1 - 1 >= 0 && r.c2 - 1 >= 0 && board[r.r1][r.c1 - 1] != 1
										&& board[r.r2][r.c2 - 1] != 1) {
									visited[r.r1 - 1][r.c1 - 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 - 1, r.c1 - 1, r.r2, r.c2, 0));
									visited[r.r1][r.c1][r.r2 + 1][r.c2 - 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 + 1, r.c2 - 1, 0));
								}
								// 오른쪽으로
								if (r.c1 + 1 < n && r.c2 + 1 < n && board[r.r1][r.c1 + 1] != 1
										&& board[r.r2][r.c2 + 1] != 1) {
									visited[r.r1 - 1][r.c1 + 1][r.r2][r.c2] = true;
									q.add(new Robot(r.r1 - 1, r.c1 + 1, r.r2, r.c2, 0));
									visited[r.r1][r.c1][r.r2 + 1][r.c2 + 1] = true;
									q.add(new Robot(r.r1, r.c1, r.r2 + 1, r.c2 + 1, 0));
								}
							}
						}
					} else {
						// 상하좌우 이동
						int nextR1 = r.r1 + dr[j];
						int nextC1 = r.c1 + dc[j];
						int nextR2 = r.r2 + dr[j];
						int nextC2 = r.c2 + dc[j];
						// 1이 없거나 이동한 흔적이 없으면 이동한다.
						if (nextR1 >= 0 && nextR2 >= 0 && nextR1 < n && nextR2 < n && nextC1 >= 0 && nextC2 >= 0
								&& nextC1 < n && nextC2 < n && !visited[nextR1][nextC1][nextR2][nextC2]) {
							if (r.d == 0) {
								// 가로
								if (j < 2 && (board[nextR1][nextC1] == 1 && board[nextR2][nextC2] == 1)) {
									continue;
								}
								if (j >= 2 && !(board[nextR1][nextC1] != 1 && board[nextR2][nextC2] != 1)) {
									continue;
								}

							} else {
								// 가로
								if (j >= 2 && (board[nextR1][nextC1] == 1 && board[nextR2][nextC2] == 1)) {
									continue;
								}
								if (j < 2 && !(board[nextR1][nextC1] != 1 && board[nextR2][nextC2] != 1)) {
									continue;
								}
							}
							visited[nextR1][nextC1][nextR2][nextC2] = true;
							q.add(new Robot(nextR1, nextC1, nextR2, nextC2, r.d));
						}
					}
				}
			}
			time++;
		}

	}
}