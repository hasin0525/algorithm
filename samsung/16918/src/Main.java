import java.util.Scanner;

public class Main {
	static class Pair {
		int x, y, t;

		public Pair(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

	}

	static int r, c, n;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Scanner sc = new Scanner(System.in);

	static void plusTime() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 1) {
					map[i][j] += 1;
				}
			}
		}
	}

	static void makeBomb() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
				}
			}
		}
	}

	static void bombing() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 3) {
					map[i][j] = 0;
					for(int k = 0; k < 4; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && map[nextX][nextY] < 3) {
							map[nextX][nextY] = 0;
						}
					}
				}
			}
		}
	}

	static void go() {
		int time = 1;
		if (time == n) {
			return;
		}
		while (true) {
			plusTime();
			makeBomb();
			time += 1;
			if (time == n) {
				return;
			}
			plusTime();
			bombing();
			time += 1;
			if (time == n) {
				return;
			}
		}
	}

	public static void showMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 1) {
					System.out.print('O');
				} else {
					System.out.print('.');
				}
				//System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		r = sc.nextInt();
		c = sc.nextInt();
		n = sc.nextInt();
		sc.nextLine();
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			String inputs = sc.nextLine();
			for (int j = 0; j < c; j++) {
				char input = inputs.charAt(j);
				if (input == 'O') {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}
		go();
		showMap();
	}

}
