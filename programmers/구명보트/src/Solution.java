import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);

		int min = 0;
		int max = people.length - 1;
		while (true) {
			if(max < min) {
				break;
			}
			if (min == max) {
				answer += 1;
				break;
			}
			if (people[max] + people[min] <= limit) {
				answer += 1;
				max--;
				min++;
			}else {
				answer+=1;
				max--;
			}
		}

		return answer;
	}
}