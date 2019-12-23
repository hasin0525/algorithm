import java.util.LinkedList;
import java.util.List;

class Solution {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> answer = new LinkedList<>();
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex < A.length && bIndex < B.length) {
			int start = Math.max(A[aIndex][0], B[bIndex][0]);
			int end = Math.min(A[aIndex][1], B[bIndex][1]);
			if (A[aIndex][1] <= B[bIndex][0]) {
				aIndex++;
				continue;
			}
			if (A[aIndex][0] => B[bIndex][1]) {
				bIndex++;
				continue;
			}
			answer.add(new int[] { start, end });
		}

		return answer.toArray(new int[answer.size()][]);
	}
}