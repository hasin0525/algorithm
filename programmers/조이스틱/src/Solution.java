import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {
	class Info {
		int index, value;

		public Info(int index, int value) {
			this.index = index;
			this.value = value;
		}

	}

	public int solution(String name) {
		int answer = 0;

		char[] names = name.toCharArray();
		LinkedList<Info> changelist = new LinkedList<>();
		for (int i = 0; i < names.length; i++) {
			if (names[i] != 'A') {
				changelist.add(new Info(i, 0));
			}
		}

		int index = 0;
		while (changelist.size() != 0) {
			// 자신에서 가장 가까운 리스트 비교하기
			Iterator<Info> it = changelist.iterator();
			while (it.hasNext()) {
				Info cur = it.next();
				if (index == cur.index) {
					cur.value = 0;
				} else if (index < cur.index) {
					cur.value = Math.min(Math.abs(cur.index - index), index + names.length - cur.index);
				} else {
					cur.value = Math.min(Math.abs(cur.index - index), names.length - index - 1 + cur.index);
				}
			}
			Collections.sort(changelist, new Comparator<Info>() {
				public int compare(Info o1, Info o2) {
					return o1.value - o2.value;
				}
			});
			Info cur = changelist.poll();
			answer += cur.value;
			char value = names[cur.index];
			index = cur.index;
			// up down 차이 비교
			answer += Math.min(Math.abs('A' - value), 'Z' - value + 1);
			
		}
		return answer;
	}
}