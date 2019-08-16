import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Laser implements Comparable<Laser> {
		int x, y, d, c;

		public Laser(int x, int y, int d, int c) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Laser o) {
			// TODO Auto-generated method stub
			return this.c - o.c;
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] d1 = { 2, 3, 0, 1 };
	static int[] d2 = { 3, 2, 1, 0 };
	static char[][] map;
	static int[][] dist;
	static int w, h, result = Integer.MAX_VALUE, laserX2, laserY2;
	static Scanner sc = new Scanner(System.in);
	static PriorityQueue<Laser> laserList;

	public static void bfs() {
		while (!laserList.isEmpty()) {
			Laser cur = laserList.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				int nextC = cur.c;
				if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] != '*') {
					if(i != cur.d) nextC++;
					if(dist[nextX][nextY] >= nextC) {
						dist[nextX][nextY] = nextC;
						laserList.add(new Laser(nextX, nextY, i, nextC));
					}
					
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		w = sc.nextInt();
		h = sc.nextInt();
		sc.nextLine();
		map = new char[h][w];
		dist = new int[h][w];
		laserList = new PriorityQueue<Laser>();
		int laserX = 0;
		int laserY = 0;
		for (int i = 0; i < h; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'C') {
					laserList.add(new Laser(i, j, 0, 0));
				}
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		Laser destination1 = laserList.poll();
		laserX = destination1.x;
		laserY = destination1.y;
		Laser destination2 = laserList.poll();
		laserX2 = destination2.x;
		laserY2 = destination2.y;

		for (int i = 0; i < 4; i++) {
			laserList.add(new Laser(laserX, laserY, i, 0));
		}
		dist[laserX][laserY] = 0;
		bfs();
		System.out.println(dist[laserX2][laserY2]);
	}

}
