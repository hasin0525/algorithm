import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	class Info implements Comparable<Info> {
		int start, time;

		public Info(int start, int time) {
			this.start = start;
			this.time = time;
		}

		@Override
		public int compareTo(Info o) {
			return this.time - o.time;
		}

	}

	public int solution(int[][] jobs) {
		ArrayList<Info> joblist = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			joblist.add(new Info(jobs[i][0], jobs[i][1]));
		}
		Collections.sort(joblist, new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				return o1.start - o2.start;
			}

		});
		PriorityQueue<Info> pq = new PriorityQueue<>();
		int answer = 0;
		int time = 0;
		int index = 0;
		while (true) {
			if (index >= joblist.size() && pq.isEmpty()) {
				break;
			}
			for (int i = index; i < joblist.size(); i++) {
				if (time >= joblist.get(i).start) {
					pq.add(joblist.get(i));
					index += 1;
				} else {
					break;
				}
			}
			if (pq.size() != 0) {
				Info cur = pq.poll();
				time += cur.time;
				answer += (time - cur.start);
			} else {
				time += 1;
			}
		}

		return answer / jobs.length;
	}
}