package test;

public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int r = 0, c = 0;
		int d = 0;
		int temp = arr[r][c];
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				if (!(nextR >= 0 && nextR <= 2 && nextC >= 0 && nextC <= 2)) {
					break;
				}
				arr[r][c] = arr[nextR][nextC];
				r = nextR;
				c = nextC;
			}
		}
		arr[0][1] = temp;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3 ;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
