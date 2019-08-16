import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Robot {
		int r, c, d;

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static int[] dr = { 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][][] visited;
	static Queue<Robot> robotList;
	static int m, n, destR, destC, destD;
	static Scanner sc = new Scanner(System.in);

	static int bfs() {
		int count = 0;
		while (!robotList.isEmpty()) {
			int robotListSize = robotList.size();
			for (int i = 0; i < robotListSize; i++) {
				Robot cur = robotList.poll();
				if (cur.r == destR && cur.c == destC && cur.d == destD) {
					return count;
				}
				// 명령1
				int nextR = cur.r;
				int nextC = cur.c;
				for (int k = 1; k <= 3; k++) {
					nextR += dr[cur.d];
					nextC += dc[cur.d];
					if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
						if (!visited[nextR][nextC][cur.d]) {
							if (map[nextR][nextC] == 0) {
								visited[nextR][nextC][cur.d] = true;
								robotList.add(new Robot(nextR, nextC, cur.d));
							} else {
								// 만약 맨 아래단계에서 map에 걸렸다면...?
								break;
							}
						}
					}
				}
				// 명령2
				switch (cur.d) {
				case 1:
				case 2:
					if (!visited[cur.r][cur.c][4]) {
						visited[cur.r][cur.c][4] = true;
						robotList.add(new Robot(cur.r, cur.c, 4));
					}
					if (!visited[cur.r][cur.c][3]) {
						visited[cur.r][cur.c][3] = true;
						robotList.add(new Robot(cur.r, cur.c, 3));
					}
					break;
				case 3:
				case 4:
					if (!visited[cur.r][cur.c][1]) {
						visited[cur.r][cur.c][1] = true;
						robotList.add(new Robot(cur.r, cur.c, 1));
					}
					if (!visited[cur.r][cur.c][2]) {
						visited[cur.r][cur.c][2] = true;
						robotList.add(new Robot(cur.r, cur.c, 2));
					}
					break;
				}
			}
			count++;
		}
		// 이 경우는 절대 없다.
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		visited = new boolean[m][n][5];
		robotList = new LinkedList<Robot>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int curR = sc.nextInt() - 1;
		int curC = sc.nextInt() - 1;
		int curD = sc.nextInt();
		robotList.add(new Robot(curR, curC, curD));		
		visited[curR][curC][curD] = true;
		destR = sc.nextInt() - 1;
		destC = sc.nextInt() - 1;
		destD = sc.nextInt();
		System.out.println(bfs());
	}

}
