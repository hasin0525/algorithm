import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> remainingTime = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			int remainingPercent = 100 - progresses[i];
			int rt = remainingPercent / speeds[i];
			if (remainingPercent % speeds[i] != 0) {
				rt += 1;
			}
			System.out.println(rt);
			remainingTime.add(rt);
		}

		List<Integer> answer = new LinkedList<>();

		if (remainingTime.size() == 1) {
			return new int[] { remainingTime.poll() };
		}

		int basic = remainingTime.poll();
		int count = 1;
		while (!remainingTime.isEmpty()) {
			int current = remainingTime.poll();
			if (basic >= current) {
				count += 1;
				if(remainingTime.isEmpty()) {
					answer.add(count);
				}
			} else {
				answer.add(count);
				basic = current;
				count = 1;
				
				if(remainingTime.isEmpty()) {
					answer.add(count);
				}
				
			}
		}
		
		return answer.stream().mapToInt(i->i).toArray();
	}
}