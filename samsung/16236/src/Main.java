import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Info implements Comparable<Info> {
		int r, c, v, exp;

		public Info(int r, int c, int v, int exp) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.exp = exp;
		}

		@Override
		public int compareTo(Info o) {
			int differ = this.r - o.r;
			if (differ == 0) {
				return this.c - o.c;
			}
			return differ;
		}

	}

	static int n, result;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int[][] map;
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Info> fishlist;
	static Queue<Info> sharklist;
	static int sv, sexp;
	public static void bfs() {
		int time = 0;
		while (!sharklist.isEmpty()) {
			int qsize = sharklist.size();
			for (int i = 0; i < qsize; i++) {
				Info shark = sharklist.poll();
				for (int j = 0; j < 4; j++) {
					int nextR = shark.r + dr[j];
					int nextC = shark.c + dc[j];

					if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]
							&& map[nextR][nextC] <= sv) {
						if (map[nextR][nextC] < sv && map[nextR][nextC] > 0) {
							fishlist.add(new Info(nextR, nextC, map[nextR][nextC], 0));
						}
						sharklist.add(new Info(nextR, nextC, sv, sexp));
						visited[nextR][nextC] = true;
					}
				}
			}
			time++;
			if(!fishlist.isEmpty()) {
				Collections.sort(fishlist);
				Info eatingFish = fishlist.poll();
				sexp += 1;
				if(sexp == sv) {
					sexp = 0;
					sv += 1;
				}
				map[eatingFish.r][eatingFish.c] = 0;
				visited = new boolean[n][n];
				visited[eatingFish.r][eatingFish.c] = true;
				sharklist.clear();
				fishlist.clear();
				sharklist.add(new Info(eatingFish.r, eatingFish.c,sv,sexp));
				result = time;
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		fishlist = new LinkedList<>();
		sharklist = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					map[i][j] = 0;
					sv = 2;
					sexp = 0;
					sharklist.add(new Info(i, j, 2, 0));
					visited[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(result);
	}

}
