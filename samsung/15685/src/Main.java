import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int t, x, y, d, g;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> s;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		t = sc.nextInt();
		visited = new boolean[101][101];
		for (int i = 0; i < t; i++) {
			s = new ArrayList<>();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			visited[y][x] = true;
			s.add(d);
			x += dx[d];
			y += dy[d];
			visited[y][x] = true;
			for (int j = 0; j < g; j++) {
				for (int k = s.size() - 1; k >= 0; k--) {
					int nd = ((s.get(k) + 1) % 4);
					x += dx[nd];
					y += dy[nd];
					visited[y][x] = true;
					s.add(nd);
				}
			}
		}
		// 정사각형찾기
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]) {
					count += 1;
				}
			}
		}
		System.out.println(count);
	}

}
