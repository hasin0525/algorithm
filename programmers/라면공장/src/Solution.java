import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
	class Info implements Comparable<Info> {
		int date, supply;

		public Info(int date, int supply) {
			this.date = date;
			this.supply = supply;
		}

		@Override
		public int compareTo(Info o) {
			return o.supply - this.supply;
		}

	}

	public int solution(int stock, int[] dates, int[] supplies, int k) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 0; i < dates.length; i++) {
			
		}

		int flour = stock;
		int answer = 0;
		int index = 0;
		while (k > flour) {
			for(int i = index; i < dates.length; i++) {
				if(flour >= dates[i]) {
					pq.add(new Info(dates[i], supplies[i]));
					index = i+1;
				}
			}
			if(pq.size() != 0) {
				flour += pq.poll().supply;
				answer += 1;
			}
			
		}

		return answer;
	}
}