import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Info {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	int height, n, answer;
	int[][] land;
	int[][] map;
	int[] dr = { 0, 0, 1, -1 };
	int[] dc = { 1, -1, 0, 0 };

	public int solution(int[][] land, int height) {
		this.height = height;
		this.land = land;
		answer = Integer.MAX_VALUE;
		n = land.length;
		map = new int[n][n];

		// 1. 영역 만들기
		bfsall();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		// 2. 최소비용 찾기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] visited = new boolean[n][n];
				backtracking(i,j,visited, 0,0);
			}
		}
		
		return answer;
	}

	private void bfsall() {
		int index = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j]==0) {
					Queue<Info> q = new LinkedList<>();
					map[i][j] = index;
					q.add(new Info(i, j));
					bfs(q, index);
					index += 1;
				}
			}
		}

	}

	private void bfs(Queue<Info> q, int index) {
		while (!q.isEmpty()) {
			Info cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] == 0
						&& Math.abs(land[nextR][nextC] - land[cur.r][cur.c]) <= height) {
					map[nextR][nextC] = index;
					q.add(new Info(nextR, nextC));
				}
			}
		}

	}

	private void backtracking(int r, int c, boolean[][] visited, int v, int count) {
		if (count == n*n) {
			answer = Math.min(answer, v);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nextR = r + dr[k];
			int nextC = c + dc[k];
			if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
				visited[nextR][nextC] = true;
				if (map[nextR][nextC] != map[r][c]) {
					backtracking(nextR, nextC, visited, v + Math.abs(land[nextR][nextC] - land[r][c]),count+1);
				} else {
					backtracking(nextR, nextC, visited, v,count+1);
				}
				visited[nextR][nextC] = false;
			}
		}
	}
}