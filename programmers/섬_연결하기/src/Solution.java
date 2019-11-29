import java.util.Arrays;
import java.util.Comparator;

class Solution {

	int find(int[] parent, int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent, parent[x]);
		}
	}

	boolean union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		if (x != y) {
			parent[y] = x;
			return true;
		}
		return false;
	}

	public int solution(int n, int[][] costs) {
		int answer = 0;
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int[] cost : costs) {
			if (union(parent, cost[0], cost[1])) {
				answer += cost[2];
			}
		}
		return answer;
	}
}