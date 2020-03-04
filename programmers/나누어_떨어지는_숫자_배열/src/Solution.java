import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).map(num -> num / divisor).sorted().toArray();
		if (answer.length == 0) {
			answer = new int[]{-1};
		}
		return answer;
	}
}