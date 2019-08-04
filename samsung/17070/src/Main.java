import java.util.Scanner;

public class Main {
	static int n, count;
	static int[][] map;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(1, 2, 0);
		System.out.println(count);
	}

	private static void dfs(int i, int j, int state) {
		if (i == n && j == n) {
			count++;
			return;
		}
		switch (state) {
		case 0:
			moveY(i, j);
			moveXY(i, j);
			break;
		case 1:
			moveX(i, j);
			moveXY(i, j);
			break;
		case 2:
			moveX(i, j);
			moveY(i, j);
			moveXY(i, j);
			break;
		}
	}

	private static void moveX(int i, int j) {
		int nextX = i + 1;
		if (nextX <= n && map[nextX][j] != 1) {
			dfs(nextX, j, 1);
		}
	}

	private static void moveXY(int i, int j) {
		int nextX = i + 1;
		int nextY = j + 1;
		if (nextX <= n && nextY <= n && map[i][nextY] != 1 && map[nextX][j] != 1 && map[nextX][nextY] != 1) {
			dfs(nextX, nextY, 2);
		}
	}

	private static void moveY(int i, int j) {
		int nextY = j + 1;
		if (nextY <= n && map[i][nextY] != 1) {
			dfs(i, nextY, 0);
		}
	}

}
