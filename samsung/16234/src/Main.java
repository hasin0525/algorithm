import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class Country {
		int r, c;

		public Country(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int n, l, r, sum;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Country> unionlist;

	public static void main(String[] args) {
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 인구이동
		int count = 0;
		int newCount = 0;
		do {
			newCount = 0;
			visited = new boolean[n][n];
			boolean check = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						unionlist = new LinkedList<>();
						sum = 0;
						dfs(i, j);
						if (unionlist.size() > 1) {
							check = true;
							int movedValue = sum / unionlist.size();
							for (Country country : unionlist) {
								map[country.r][country.c] = movedValue;
							}
						}
					}
				}
			}
			if(check) {
				newCount += 1;
			}
			count += newCount;
		} while (newCount != 0);
		System.out.println(count);

	}

	private static void dfs(int row, int col) {
		unionlist.add(new Country(row, col));
		visited[row][col] = true;
		sum += map[row][col];
		for (int i = 0; i < 4; i++) {
			int nextR = row + dr[i];
			int nextC = col + dc[i];
			if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]
					&& Math.abs(map[row][col] - map[nextR][nextC]) >= l && Math.abs(map[row][col] - map[nextR][nextC]) <= r) {
				dfs(nextR, nextC);
			}
		}
	}

}
