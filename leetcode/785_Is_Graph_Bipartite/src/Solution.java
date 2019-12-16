class Solution {
	public boolean isBipartite(int[][] graph) {
		// 0 none, 1 w, 2 b
		int[] visited = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == 0) {
				if (!dfs(i, graph, visited, 1)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(int i, int[][] graph, int[] visited, int color) {
		boolean isBipart = false;
		visited[i] = color;
		for (int j = 0; j < graph[i].length; j++) {
			if (visited[graph[i][j]] == 0) {
				isBipart = dfs(j, graph, visited, (color == 1) ? 2 : 1);
			} else if (visited[graph[i][j]] == color) {
				isBipart = false;
				break;
			}
		}
		return isBipart;
	}
}