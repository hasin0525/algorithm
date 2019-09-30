import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Virus {
		int row, col;

		public Virus(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	static int result = Integer.MAX_VALUE;
	static int n, m;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static ArrayList<Virus> viruslist;
	static Scanner sc = new Scanner(System.in);

	private static void bfs(Queue<Virus> selectedViruslist, int[][] check) {
		while (!selectedViruslist.isEmpty()) {
			int size = selectedViruslist.size();
			for (int i = 0; i < size; i++) {
				Virus cur = selectedViruslist.poll();
				for (int j = 0; j < 4; j++) {
					int nextR = cur.row + dr[j];
					int nextC = cur.col + dc[j];
					if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] != 1
							&& check[nextR][nextC] == -1) {
						check[nextR][nextC] = check[cur.row][cur.col] + 1;
						selectedViruslist.add(new Virus(nextR, nextC));
					}
				}
			}
		}

		boolean isClear = true;
		int maxTime = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					if (check[i][j] == -1) {
						isClear = false;
						break;
					} else {
						maxTime = Math.max(maxTime, check[i][j]);
					}
				}

			}
		}

		if (isClear)
			result = Math.min(result, maxTime);
	}

	private static void makeCombination(int[] selectedVirus, int index, int count) {
		if (count == m) {
			int[][] check = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					check[i][j] = -1;
				}
			}

			for (int i = 0; i < viruslist.size(); i++) {
				
			}
			
			Queue<Virus> selectedViruslist = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				selectedViruslist
						.add(new Virus(viruslist.get(selectedVirus[i]).row, viruslist.get(selectedVirus[i]).col));
				check[viruslist.get(selectedVirus[i]).row][viruslist.get(selectedVirus[i]).col] = 0;
				
			}

			bfs(selectedViruslist, check);

			return;
		}
		if (index >= viruslist.size()) {
			return;
		}
		selectedVirus[count] = index;
		makeCombination(selectedVirus, index + 1, count + 1);
		makeCombination(selectedVirus, index + 1, count);
	}

	public static void main(String[] args) {
		// 1. 입력 받기
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		viruslist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					viruslist.add(new Virus(i, j));
				}
			}
		}
		// 조합 만들기
		int[] selectedVirus = new int[m];
		makeCombination(selectedVirus, 0, 0);
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

}
