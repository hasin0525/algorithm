import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Dust {
		int r, c;

		public Dust(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int r, c, t;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[] up = { 2, 1, 3, 0 };
	static int[] down = { 3, 1, 2, 0 };
	static int airR1, airC1, airR2, airC2;
	static Queue<Dust> q;

	public static void main(String[] args) {
		int count = 0;
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		map = new int[r][c];
		q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					if (count == 0) {
						airR1 = i;
						airC1 = j;
						count += 1;
					} else if (count == 1) {
						airR2 = i;
						airC2 = j;
						count += 1;
					}
				} else if (map[i][j] > 0) {
					q.add(new Dust(i, j));
				}
			}
		}
		for (int k = 0; k < t; k++) {
			spreadDust();
			rotationDust();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] > 0) {
						q.add(new Dust(i, j));
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}

	private static void rotationDust() {
		int curR = airR1;
		int curC = airC1;
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nextR = curR + dr[up[i]];
				int nextC = curC + dc[up[i]];
				if (!(nextR >= 0 && nextR <= airR1 && nextC >= 0 && nextC < c)) {
					break;
				}
				map[curR][curC] = map[nextR][nextC];
				curR = nextR;
				curC = nextC;
			}
		}
		map[airR1][airC1] = -1;
		map[airR1][airC1 + 1] = 0;

		curR = airR2;
		curC = airC2;
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nextR = curR + dr[down[i]];
				int nextC = curC + dc[down[i]];
				if (!(nextR >= airR2 && nextR < r && nextC >= 0 && nextC < c)) {
					break;
				}
				map[curR][curC] = map[nextR][nextC];
				curR = nextR;
				curC = nextC;
			}
		}
		map[airR2][airC2] = -1;
		map[airR2][airC2 + 1] = 0;
	}

	private static void spreadDust() {
		int[][] map2 = new int[r][c];
		map2[airR1][airC1] = -1;
		map2[airR2][airC2] = -1;
		while (!q.isEmpty()) {
			Dust cur = q.poll();
			int spreadValue = map[cur.r][cur.c] / 5;
			int spreadCount = 0;
			for (int j = 0; j < 4; j++) {
				int nextR = cur.r + dr[j];
				int nextC = cur.c + dc[j];
				if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c && map[nextR][nextC] != -1) {
					spreadCount += 1;
					map2[nextR][nextC] += spreadValue;
				}
			}
			map2[cur.r][cur.c] += (map[cur.r][cur.c] - spreadValue * spreadCount);
		}
		map = map2;

	}

}
