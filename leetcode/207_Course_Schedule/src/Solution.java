import java.util.ArrayList;

class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean[] visited = new boolean[numCourses];
		boolean[] isSearch = new boolean[numCourses];
		for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (dfs(i, graph, visited ,isSearch)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] isSearch) {
		if(isSearch[i]) {
			return false;
		}
		if (visited[i]) {
			return true;
		}
		visited[i] = true;
		
		for(int j = 0; j <graph.get(i).size();j++) {
			if(dfs(graph.get(i).get(j), graph, visited,isSearch)) {;
				return false;
			}
		}
		isSearch[i] = true;
		visited[i] = false;
		return false;
	}
}