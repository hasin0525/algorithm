import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Info {
		int index, priority;

		public Info(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}

	}

	public int solution(int[] priorities, int location) {
		Queue<Info> printQueue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			printQueue.add(new Info(i, priorities[i]));
		}

		int answer = 0;
		int order = 1;
		while (!printQueue.isEmpty()) {
			Info cur = printQueue.poll();
			Iterator<Info> it = printQueue.iterator();
			boolean isExist = false;
			while (it.hasNext()) {
				if (it.next().priority > cur.priority) {
					printQueue.add(cur);
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				if (cur.index == location) {
					answer = order;
					break;
				}
				order += 1;
			}
		}
		return answer;
	}
}