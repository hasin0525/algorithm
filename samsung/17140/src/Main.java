import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class Number {
		int value, count;

		public Number(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}

	static Comparator<Number> comp = new Comparator<Number>() {

		@Override
		public int compare(Number o1, Number o2) {
			int d = o1.count - o2.count;
			if (d == 0) {
				return o1.value - o2.value;
			}
			return d;
		}

	};

	static int r, c, k;
	static int rowMax = 3, colMax = 3;
	static int[][] map = new int[101][101];
	static Scanner sc = new Scanner(System.in);

	private static void rowCacul() {
		LinkedList<Number> list = new LinkedList<>();
		int[] numState = new int[101];
		int initRowMax = rowMax;
		int initColMax = colMax;
		for (int i = 1; i <= initRowMax; i++) {
			for (int j = 1; j <= initColMax; j++) {
				if (map[i][j] == 0)
					continue;
				numState[map[i][j]]++;
				map[i][j] = 0;
			}
			for (int k = 1; k <= 100; k++) {
				if (numState[k] == 0)
					continue;
				list.add(new Number(k, numState[k]));
				numState[k] = 0;
			}
			Collections.sort(list, comp);
			int index = 1;
			for (Number n : list) {
				if(index >= 101) {
					break;
				}
				map[i][index] = n.value;
				map[i][index + 1] = n.count;
				index += 2;
			}
			if(i==1 && colMax > index -1) {
				colMax = index -1;
			} else {
			colMax = Math.max(colMax, index - 1);
			}
			list.clear();
		}
	}

	private static void colCacul() {
		LinkedList<Number> list = new LinkedList<>();
		int[] numState = new int[101];
		int initRowMax = rowMax;
		int initColMax = colMax;
		for (int j = 1; j <= initColMax; j++) {
			for (int i = 1; i <= initRowMax; i++) {
				if (map[i][j] == 0)
					continue;
				numState[map[i][j]]++;
				map[i][j] = 0;
			}
			for (int k = 1; k <= 100; k++) {
				if (numState[k] == 0)
					continue;
				list.add(new Number(k, numState[k]));
				numState[k] = 0;
			}
			Collections.sort(list, comp);
			int index = 1;
			for (Number n : list) {
				if(index >= 101) {
					break;
				}
				map[index][j] = n.value;
				map[index + 1][j] = n.count;
				index += 2;
			}
			if(j==1 && rowMax > index -1) {
				rowMax = index -1;
			} else {
				rowMax = Math.max(rowMax, index - 1);
			}
			list.clear();
		}
	}

	public static void main(String[] args) {
		int time = 0;
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while (time <= 100) {
			if (map[r][c] == k) {
				System.out.println(time);
				return;
			}
			if (rowMax >= colMax) {
				rowCacul();
			} else {
				colCacul();
			}
			time++;
		}
		System.out.println(-1);
	}

}
