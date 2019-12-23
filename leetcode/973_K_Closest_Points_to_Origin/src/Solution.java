import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int[][] kClosest(int[][] points, int K) {
		int length = points.length;
		int[][] distence = new int[length][2];
		for (int i = 0; i < length; i++) {
			distence[i][0] = i;
			distence[i][1] = Math.abs(points[i][0]) * Math.abs(points[i][0])
					+ Math.abs(points[i][1]) * Math.abs(points[i][1]);
		}
		Arrays.sort(distence, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		int[][] answer = new int[K][2];
		for (int i = 0; i < K; i++) {
			answer[i] = points[distence[i][0]];
		}
		return answer;
	}
}