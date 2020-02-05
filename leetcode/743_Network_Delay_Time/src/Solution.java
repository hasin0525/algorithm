import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	class Info {
		int index, weight;

		public Info(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}

	int answer;
	int count;
	int[][] weight;
	boolean[] isVisited;
	ArrayList<ArrayList<Integer>> graph;

	public int networkDelayTime(int[][] times, int N, int K) {
		weight = new int[N + 1][N + 1];
		isVisited = new boolean[N + 1];
		graph = new ArrayList<>();
		graph.add(null);
		for (int i = 1; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] time : times) {
			graph.get(time[0]).add(time[1]);
			weight[time[0]][time[1]] = time[2];
		}

		PriorityQueue<Info> q = new PriorityQueue<>((i1, i2) -> i1.weight - i2.weight);
		q.add(new Info(K, 0));
		bfs(q);
		return count < K ? -1 : answer;
	}

	private void bfs(PriorityQueue<Info> q) {
		while (!q.isEmpty()) {
			Info cur = q.poll();
			isVisited[cur.index] = true;
			count++;
			answer += cur.weight;
			for (int next : graph.get(cur.index)) {
				if (!isVisited[next]) {
					q.add(new Info(next, weight[cur.index][next]));
				}
			}
		}
	}

}