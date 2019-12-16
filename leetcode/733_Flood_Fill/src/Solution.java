class Solution {
	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };
    boolean[][] visited;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
		dfs(sr, sc, image[sr][sc], newColor, image);
		return image;
	}

	private void dfs(int sr, int sc, int curColor, int newColor, int[][] image) {
        visited[sr][sc] = true;
		image[sr][sc] = newColor;
		for (int i = 0; i < 4; i++) {
			int nextR = sr + dr[i];
			int nextC = sc + dc[i];
			if (nextR >= 0 && nextR < image.length && nextC >= 0 && nextC < image[0].length
					&& image[nextR][nextC] == curColor && !visited[nextR][nextC]) {
				dfs(nextR, nextC, curColor, newColor, image);
			}
		}
	}
}