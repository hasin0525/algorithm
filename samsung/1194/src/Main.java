import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Info {
		int x, y, k;

		public Info(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

	}

	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<Info> q;
	static Scanner sc = new Scanner(System.in);

	static int bfs() {
		int count = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Info cur = q.poll();
				if (map[cur.x][cur.y] == '1') {
					return count;
				}
				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dx[j];
					int nextY = cur.y + dy[j];
					int nextK = cur.k;
					if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && map[nextX][nextY] != '#'
							&& !visited[nextX][nextY][nextK]) {
						// 문이 있으면
						if(map[nextX][nextY] >= 'A' && map[nextX][nextY] <= 'F') {
							if((nextK & (1 << map[nextX][nextY] - 65)) == 0) {
								continue;
							}
						}
						// 열쇠가 있으면 열쇠를 먹고
						if(map[nextX][nextY] >= 'a' && map[nextX][nextY] <= 'f') {
							nextK = cur.k | (1 << map[nextX][nextY] - 97);
						}
						visited[nextX][nextY][nextK] = true;
						q.add(new Info(nextX, nextY, nextK));
					}
				}
			}
			count++;
		}
		return -1;
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new char[n][m];
		visited = new boolean[n][m][65];
		q = new LinkedList<Info>();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					visited[i][j][0] = true;
					q.add(new Info(i, j, 0));
				}
			}
		}
		System.out.println(bfs());
	}
}
