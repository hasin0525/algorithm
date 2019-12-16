import java.util.LinkedList;
import java.util.List;

class Solution {
	List<List<Integer>> answer;
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };
	boolean[][] visited;
	boolean pacific;
	boolean Atlantic;
	int index = 1;

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		answer = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				visited = new boolean[matrix.length][matrix[0].length];
				pacific = false;
				Atlantic = false;
				dfs(i, j, matrix);
				if (pacific && Atlantic) {
					List<Integer> list = new LinkedList<>();
					list.add(i);
					list.add(j);
					answer.add(list);
				}
				index++;
			}
		}

		return answer;
	}

	private void dfs(int r, int c, int[][] matrix) {
		visited[r][c] = true;
		if (r == 0 || c == 0) {
			pacific = true;
		}
		if (r == matrix.length - 1 || c == matrix[0].length - 1) {
			Atlantic = true;
		}
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= 0 && nextR < matrix.length && nextC >= 0 && nextC < matrix[0].length
					&& matrix[nextR][nextC] <= matrix[r][c] && !visited[nextR][nextC]) {
				dfs(nextR, nextC, matrix);
			}
		}
	}
}