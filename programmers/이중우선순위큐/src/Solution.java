import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		for (String oper : operations) {
			switch (oper.charAt(0)) {
			case 'I':
				int inputValue = Integer.parseInt(oper.substring(2));
				min.add(inputValue);
				max.add(inputValue);
				break;
			case 'D':
				if (min.size() == 0) {
					continue;
				}
				inputValue = Integer.parseInt(oper.substring(2));
				if (inputValue > 0) {
					int maxValue = max.poll();
					min.remove(maxValue);
				} else {
					int minValue = min.poll();
					max.remove(minValue);
				}
				break;
			}
		}
		int[] answer;
		if (min.size() == 0) {
			answer=new int[]{0,0};
		}else if(min.size() == 1) {
			answer=new int[]{min.peek(),min.peek()};
		}else {
			answer=new int[]{max.peek(),min.peek()};
		}
		return answer;
	}
}