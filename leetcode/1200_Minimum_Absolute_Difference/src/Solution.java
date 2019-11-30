import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.parallelSort(arr);
		int minDif = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int dif = arr[i + 1] - arr[i];
			minDif = Math.min(minDif, dif);
		}

		List<List<Integer>> answer = new LinkedList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			int dif = arr[i + 1] - arr[i];
			if(dif == minDif) {
				answer.add(Arrays.asList(arr[i], arr[i+1]));
			}
		}
		return answer;
	}
}