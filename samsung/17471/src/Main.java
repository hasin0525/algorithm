import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int value;
		int[] adjacency;

		public Node(int value) {
			this.value = value;
		}
	}

	static int n, result = Integer.MAX_VALUE;
	static Scanner sc = new Scanner(System.in);
	static Node[] nodelist;

	public static boolean bfs(Queue<Node> q, HashSet<Integer> selectedNodeList, boolean[] visited) {
		
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				Node cur = q.poll();
				for (int index : cur.adjacency) {
					if (!visited[index] && selectedNodeList.contains(index)) {
						visited[index] = true;
						q.add(nodelist[index]);
					}
				}
			}
		}
		int count = 0;
		for (int index : selectedNodeList) {
			if (visited[index]) {
				count += 1;
			}
		}
		if (count == selectedNodeList.size()) {
			return true;
		}
		return false;
	}

	public static void makeCombination(int index, boolean[] selectedNode) {
		if (index == n + 1) {
			HashSet<Integer> selectedNodeList1 = new HashSet<>();
			Queue<Node> q1 = new LinkedList<>();
			int count = 0;
			int sum1 = 0;
			boolean[] visited1 = new boolean[n + 1];
			
			HashSet<Integer> selectedNodeList2 = new HashSet<>();
			Queue<Node> q2 = new LinkedList<>();
			int count2 = 0;
			int sum2 = 0;
			boolean[] visited2 = new boolean[n + 1];
			
			for (int i = 1; i <= n; i++) {
				if (selectedNode[i]) {
					selectedNodeList1.add(i);
					sum1 += nodelist[i].value;
					if (count == 0) {
						visited1[i] = true;
						q1.add(nodelist[i]);
						count += 1;
					}
				} else {
					selectedNodeList2.add(i);
					sum2 += nodelist[i].value;
					if (count2 == 0) {
						visited2[i] = true;
						q2.add(nodelist[i]);
						count2 += 1;
					}
				}
			}

			if (selectedNodeList2.size() == 0 || selectedNodeList1.size() == 0) {
				return;
			}
			
			boolean isAdject1 = bfs(q1, selectedNodeList1, visited1);
			boolean isAdject2 = bfs(q2, selectedNodeList2, visited2);
			
			if (isAdject1 && isAdject2) {
				result = Math.min(result, Math.abs(sum1 - sum2));
			}

			return;
		}
		selectedNode[index] = true;
		makeCombination(index + 1, selectedNode);
		selectedNode[index] = false;
		makeCombination(index + 1, selectedNode);
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		nodelist = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			nodelist[i] = new Node(sc.nextInt());
		}
		for (int i = 1; i <= n; i++) {
			int adjacencyNum = sc.nextInt();
			nodelist[i].adjacency = new int[adjacencyNum];
			for (int j = 0; j < adjacencyNum; j++) {
				nodelist[i].adjacency[j] = sc.nextInt();
			}
		}

		boolean[] selectedNode = new boolean[n + 1];
		// 조합을 만든다.
		makeCombination(1, selectedNode);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
