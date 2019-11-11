import java.util.Scanner;

public class Main {
	static char[][] map;
	static int n, m, destX, destY, redX, redY, blueX, blueY, result = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][][][][] visited;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					redX = i;
					redY = j;
				} else if (map[i][j] == 'B') {
					blueX = i;
					blueY = j;
				} else if (map[i][j] == 'O') {
					destX = i;
					destY = j;
				}
			}
		}
		visited = new boolean[n][m][n][m][12];
		visited[redX][redY][blueX][blueY][0] = true;
		for (int i = 0; i < 4; i++) {
			start(redX, redY, blueX, blueY, 0, i);
		}
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void start(int rx, int ry, int bx, int by, int count, int dir) {

		// dir 방향으로 #이 나오거나 o가 나올때까지 움직인다.
		int nrx = rx;
		int nry = ry;
		int nbx = bx;
		int nby = by;
		while (map[nrx][nry] != '#' && map[nrx][nry] != 'O') {
			nrx += dx[dir];
			nry += dy[dir];
		}
		if (map[nrx][nry] == '#') {
			nrx -= dx[dir];
			nry -= dy[dir];
		}
		while (map[nbx][nby] != '#' && map[nbx][nby] != 'O') {
			nbx += dx[dir];
			nby += dy[dir];
		}
		if (map[nbx][nby] == '#') {
			nbx -= dx[dir];
			nby -= dy[dir];
		}
		if (map[nrx][nry] == 'O' && map[nbx][nby] != 'O') {
			result = Math.min(result, count + 1);
			return;
		}
		if (map[nbx][nby] == 'O') {
			return;
		}
		// 다 움직였으면 만약 두 공이 겹치면 교통정리
		if (nrx == nbx && nry == nby) {
			// 초기 위치 기준으로
			switch (dir) {
			case 0:
				if (ry > by) {
					nrx -= dx[dir];
					nry -= dy[dir];
				} else {
					nbx -= dx[dir];
					nby -= dy[dir];
				}
				break;
			case 1:
				if (ry > by) {
					nbx -= dx[dir];
					nby -= dy[dir];
				} else {
					nrx -= dx[dir];
					nry -= dy[dir];
				}
				break;
			case 2:
				if (rx > bx) {
					nrx -= dx[dir];
					nry -= dy[dir];
				} else {
					nbx -= dx[dir];
					nby -= dy[dir];
				}
				break;
			case 3:
				if (rx > bx) {
					nbx -= dx[dir];
					nby -= dy[dir];
				} else {
					nrx -= dx[dir];
					nry -= dy[dir];
				}
				break;
			}
		}
		count += 1;
		if (visited[nrx][nry][nbx][nby][count]) {
			return;
		}
		visited[nrx][nry][nbx][nby][count] = true;
		// 자신의 반대 방향을 제외한 나머지 방향에 대해서 움직인다.
		
		if (count > 10) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			start(nrx, nry, nbx, nby, count, i);
		}
	}
}
