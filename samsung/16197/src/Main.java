import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static char[][] map;
	static int n, m, result = Integer.MAX_VALUE;
	static Scanner sc = new Scanner(System.in);
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void move(int x1, int y1, int x2, int y2, int count) {
		if(count >= 10) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextX1 = x1 + dx[i];
			int nextY1 = y1 + dy[i];
			int nextX2 = x2 + dx[i];
			int nextY2 = y2 + dy[i];
			// 만약 두 동전이 둘다 살아 있으면 q에 넣는다.
			if ((nextX1 >= 0 && nextX1 < n && nextY1 >= 0 && nextY1 < m)
					&& (nextX2 >= 0 && nextX2 < n && nextY2 >= 0 && nextY2 < m)) {
				if (map[nextX1][nextY1] == '#' && map[nextX2][nextY2] != '#') {
					move(x1, y1, nextX2, nextY2, count + 1);
				} else if (map[nextX1][nextY1] != '#' && map[nextX2][nextY2] == '#') {
					move(nextX1, nextY1, x2, y2, count + 1);
				} else if (map[nextX1][nextY1] != '#' && map[nextX2][nextY2] != '#') {
					move(nextX1, nextY1, nextX2, nextY2, count + 1);
				}
			} else if (!(nextX1 >= 0 && nextX1 < n && nextY1 >= 0 && nextY1 < m)
					^ !(nextX2 >= 0 && nextX2 < n && nextY2 >= 0 && nextY2 < m)) {
				result = Math.min(result, count + 1);
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new char[n][m];
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'o' && count == 0) {
					count++;
					x1 = i;
					y1 = j;
				} else if (map[i][j] == 'o' && count == 1) {
					count++;
					x2 = i;
					y2 = j;
				}
			}
		}
		move(x1, y1, x2, y2, 0);
		if (result != Integer.MAX_VALUE) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}
}
