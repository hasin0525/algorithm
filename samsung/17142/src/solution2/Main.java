package solution2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Virus {
		int r, c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static Scanner sc = new Scanner(System.in);
	static int n, m, zeroCount, result = Integer.MAX_VALUE;
	static int[][] initMap;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static ArrayList<Virus> viruslist;
	static Queue<Virus> q;
	static int count;

	public static void bfs() {
		int count = 0;
		int time = 0;
		while (!q.isEmpty()) {
			if (zeroCount == count) {
				if (result == -1) {
					result = time;
				} else {
					result = Math.min(result, time);
				}
				return;
			}
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Virus v = q.poll();
				for (int j = 0; j < 4; j++) {
					int nextR = v.r + dr[j];
					int nextC = v.c + dc[j];
					if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]
							&& map[nextR][nextC] != 1) {
						if(map[nextR][nextC] == 0) {
							count+=1;
						}
						visited[nextR][nextC] = true;
						map[nextR][nextC] = 2;
						q.add(new Virus(nextR,nextC));
					}
				}
			}
			time += 1;
		}

		// 만약 -1이면 상대방이 -1 보다 크고 maxvalue가 아니면
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
	}

	public static void makeCombination(int index, int cur, int max, int[] selectedVirus) {
		if (cur == m) {
			// 맵 초기화
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = initMap[i][j];
				}
			}
			// 바이러스 방문체크와 q에 넣기
			visited = new boolean[n][n];
			q = new LinkedList<>();
			for (int i : selectedVirus) {
				Virus curV = viruslist.get(i);
				visited[curV.r][curV.c] = true;
				q.add(curV);
			}
			// bfs
			bfs();
			// 시간 체크
			return;
		}
		for (int i = index; i < max; i++) {
			selectedVirus[cur] = i;
			makeCombination(i + 1, cur + 1, max, selectedVirus);
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		initMap = new int[n][n];
		viruslist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				initMap[i][j] = sc.nextInt();
				if (initMap[i][j] == 0) {
					zeroCount += 1;
				} else if (initMap[i][j] == 2) {
					viruslist.add(new Virus(i, j));
				}
			}
		}
		int[] selectedVirus = new int[m];
		makeCombination(0, 0, viruslist.size(), selectedVirus);
		System.out.println(result);
	}

}
