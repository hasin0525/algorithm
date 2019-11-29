import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution(int[][] routes) {
		int answer = 1;
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		int baseIndex = 0;
		for(int i = 1; i < routes.length; i++) {
			if(routes[baseIndex][1] >= routes[i][0]) {
				if(routes[baseIndex][1] >= routes[i][1]) {
					baseIndex = i;
				}
			}else {
				answer +=1;
				baseIndex = i;
			}
		}
		return answer;
	}
}