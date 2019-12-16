import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> answer = new LinkedList<>();
		int[] dr = { 0, 0, -1, 1, 1, -1, -1, 1 };
		int[] dc = { -1, 1, 0, 0, 1, -1, 1, -1 };
		boolean[] check = new boolean[8];

		int r = king[0];
		int c = king[1];
		int count = 7;

		for (int i = 1; i <= count; i++) {
			for (int j = 0; j < 8; j++) {
				if (check[j]) {
					continue;
				}
				int nextR = r + dr[j] * i;
				int nextC = c + dc[j] * i;
				if (nextR >= 0 && nextR < 8 && nextC >= 0 && nextC < 8) {
					for (int[] q : queens) {
						if (nextR == q[0] && nextC == q[1]) {
							check[j] = true;
							LinkedList<Integer> list = new LinkedList<>();
							list.add(nextR);
							list.add(nextC);
							answer.add(list);
							break;
						}
					}
				}
			}
		}

		return answer;
	}
}