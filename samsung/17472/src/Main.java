import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static class Info {
		int r, c, d;

		public Info(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map;

	static ArrayList<Info> islandList = new ArrayList<>();

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						islandList.add(new Info(i, j, k));
					}
				}
			}
		}
		
	}

}
