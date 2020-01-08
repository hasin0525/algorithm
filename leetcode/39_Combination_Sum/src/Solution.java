import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> answer = new ArrayList<>();
	private int length, target;
	private int[] candidates;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		length = candidates.length;
		this.candidates = candidates;
		this.target = target;
		int[] maxCount = new int[length];
		for (int i = 0; i < length; i++) {
			maxCount[i] = target / candidates[i];
		}

		int[] curCount = new int[length];
		combi(0, curCount, maxCount, target);
		return answer;
	}

	private void combi(int index, int[] curCount, int[] maxCount, int sum) {
		if(sum < 0) {
			return;
		}
		if (index == length) {
			if(sum != 0) {
				return;
			}
			for (int i = 0; i < length; i++) {
				sum += curCount[i] * candidates[i];
			}
			if(sum == target) {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < length; i++) {
					for(int j = 0; j < curCount[i]; j++) {
						list.add(candidates[i]);
					}
				}
				answer.add(list);
			}
			return;
		}
		for (int j = 0; j <= maxCount[index]; j++) {
			curCount[index] = j;
			combi(index+1,curCount,maxCount, sum - curCount[index] * candidates[index]);
		}
	}
}