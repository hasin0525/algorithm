import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int s : scoville) {
			pq.add(s);
		}

		int answer = 0;
		while (true) {
			if (pq.peek() < K) {
				if (pq.size() == 1) {
					answer = -1;
					break;
				}
				int first = pq.poll();
				int second = pq.poll();
				pq.add(first + second * 2);
				answer += 1;
			} else {
				break;
			}
		}

		return answer;
	}
}