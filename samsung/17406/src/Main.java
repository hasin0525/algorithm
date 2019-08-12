import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static class Pair {
		int x, y, r;

		public Pair(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	static int n, m, k, result = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] newMap;
	static ArrayList<Pair> skillList;
	static Scanner sc = new Scanner(System.in);

	public static void rotation(int rotationX, int rotationY, int rotationR) {
		for (int i = 1; i <= rotationR; i++) {
			int x1 = rotationX - i;
			int y1 = rotationY - i;
			// int x1y1 = newMap[x1][y1];
			int x2 = rotationX - i;
			int y2 = rotationY + i;
			int x2y2 = newMap[x2][y2];
			int x3 = rotationX + i;
			int y3 = rotationY - i;
			int x3y3 = newMap[x3][y3];
			int x4 = rotationX + i;
			int y4 = rotationY + i;
			int x4y4 = newMap[x4][y4];
			// 회전을 시작한다.
			for (int j = y2; j > y1; j--) {
				newMap[x2][j] = newMap[x2][j - 1];
			}
			for (int j = x4; j > x2; j--) {
				newMap[j][y4] = newMap[j - 1][y4];
			}
			newMap[x2 + 1][y2] = x2y2;
			for (int j = y3; j < y4; j++) {
				newMap[x3][j] = newMap[x3][j + 1];
			}
			newMap[x4][y4 - 1] = x4y4;
			for (int j = x1; j < x3; j++) {
				newMap[j][y1] = newMap[j + 1][y1];
			}
			newMap[x3 - 1][y3] = x3y3;
		}
	}

	public static void permutation(int count, int[] selectArray, boolean[] selectCheck) {
		if (count == k) {
			// 사용할 맵을 만든다.
			newMap = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			// 회전을 다 한다.
			for (int i = 0; i < k; i++) {
				Pair curPair = skillList.get(selectArray[i]);
				rotation(curPair.x, curPair.y, curPair.r);
			}
			// 회전을 다 한 후에 한줄씩 값을 확인한다.
			for (int i = 0; i < n; i++) {
				int temp = 0;
				for (int j = 0; j < m; j++) {
					temp += newMap[i][j];
				}
				result = Math.min(result, temp);
			}
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!selectCheck[i]) {
				selectCheck[i] = true;
				selectArray[count] = i;
				permutation(count + 1, selectArray, selectCheck);
				selectCheck[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		skillList = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 공간왜곡의 갯수
		for (int i = 0; i < k; i++) {
			skillList.add(new Pair(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
		}
		// 중복없는 순열을 만들어야 한다.
		int[] selectArray = new int[k];
		boolean[] selectCheck = new boolean[k];
		permutation(0, selectArray, selectCheck);
		System.out.println(result);
	}

}
