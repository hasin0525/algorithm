import java.util.Scanner;

public class Main {
	static int result = Integer.MAX_VALUE;
	static int[][] arr = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static Scanner sc = new Scanner(System.in);

	static void changeArr(int row, int col, int max, int value) {
		for (int i = row; i < row + max; i++) {
			for (int j = col; j < col + max; j++) {
				arr[i][j] = value;
			}
		}
	}

	static boolean checkZero(int row, int col, int max) {
		for (int i = row; i < row + max; i++) {
			for (int j = col; j < col + max; j++) {
				if (i >= 10 || j >= 10 || arr[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	static void backtracking(int row, int col) {
		if (col >= 10) {
			backtracking(row + 1, 0);
			return;
		}
		if (row >= 10) {
			// 모든 1을 커버한 경우만 들어온다.
			result = Math.min(result, 25 - (paper[1] + paper[2] + paper[3] + paper[4] + paper[5]));
			return;
		}

		if (arr[row][col] == 1) {
			for (int i = 1; i <= 5; i++) {
				if (paper[i] > 0 && !checkZero(row, col, i)) {
					paper[i]--;
					changeArr(row, col, i, 0);
					backtracking(row, col + i);
					changeArr(row, col, i, 1);
					paper[i]++;
				}
			}
		} else {
			backtracking(row, col + 1);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		backtracking(0, 0);
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
	}
}