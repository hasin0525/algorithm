import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair {
		int x, y, k;

		public Pair(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] kdx = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] kdy = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[][] map;
	static boolean[][][] visited;
	static int k, w, h;
	static Scanner sc = new Scanner(System.in);
	static Queue<Pair> monkey = new LinkedList<Pair>();

	public static int bfs() {
		int count = 0; // 움직인 횟수
		// 최소값을 구해야한다.
		while (!monkey.isEmpty()) {
			int size = monkey.size();
			for (int i = 0; i < size; i++) {
				Pair cur = monkey.poll();
				if (cur.x == h - 1 && cur.y == w - 1) {
					return count;
				}
				// k 카운트가 남았으면 특수 움직임
				if (cur.k > 0) {
					for (int j = 0; j < 8; j++) {
						int nextX = cur.x + kdx[j];
						int nextY = cur.y + kdy[j];
						if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !visited[nextX][nextY][cur.k - 1]
								&& map[nextX][nextY] != 1) {
							visited[nextX][nextY][cur.k - 1] = true;
							monkey.add(new Pair(nextX, nextY, cur.k - 1));
						}
					}
				}
				// 기본 4방향 움직임
				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dx[j];
					int nextY = cur.y + dy[j];
					if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !visited[nextX][nextY][cur.k]
							&& map[nextX][nextY] != 1) {
						visited[nextX][nextY][cur.k] = true;
						monkey.add(new Pair(nextX, nextY, cur.k));
					}
				}
			}
			count++;
		}
		return -1;
	}

	public static void main(String[] args) {
		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w];
		visited = new boolean[h][w][k + 1];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		monkey.add(new Pair(0, 0, k));
		for (int i = 0; i <= k; i++) {
			visited[0][0][i] = true;
		}
		System.out.println(bfs());
	}

}
