import java.util.ArrayList;

class Solution {
	public int[] solution(int[] answers) {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		int[] count = new int[3];
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < answers.length; i++) {
				int arrIndex = i;
				if (j == 0) {
					arrIndex %= 5;
				} else if (j == 1) {
					arrIndex %= 8;
				} else if (j == 2) {
					arrIndex %= 10;
				}
				if (answers[i] == arr[j][arrIndex]) {
					count[j] += 1;
				}
			}
		}

		int maxValue = Math.max(count[0], Math.max(count[1], count[2]));
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (maxValue == count[i]) {
				answer.add(i + 1);
			}
		}
		int[] result = new int[answer.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = answer.get(i);
		}
		return result;
	}
}