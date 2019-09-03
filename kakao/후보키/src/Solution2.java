import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

class Solution2 {
	LinkedList<Integer> list;
	int column, row;

	public boolean checkOnly(int key, String[][] relation) {

		for (int i = 0; i < row; i++) {
			for (int j = i + 1; j < row; j++) {
				// 여기서 key값이 1인 컬럼만 비교해서 다 똑같으면 return false;
				boolean check = true;
				for (int k = 0; k < column; k++) {
					if (((key & (1 << k)) >> k) == 1) {
						// 한번이라도 다르면 false
						if (!relation[i][k].equals(relation[j][k])) {
							check = false;
						}
					}
				}
				if (check) {
					return false;
				}
			}
		}

		return true;
	}

	public void makeCombination(int index, int key, String[][] relation) {
		if (index == column) {
			// 유일성 검증하고 list에 넣는다.
			if (checkOnly(key, relation)) {
				list.add(key);
			}
			return;
		}
		key = key | (1 << index);
		makeCombination(index + 1, key, relation);
		key = key & ~(1 << index);
		makeCombination(index + 1, key, relation);
	}

	public int solution(String[][] relation) {
		int answer = 0;

		// 비트를 저장할 list를 만들자.
		list = new LinkedList<>();
		column = relation[0].length;
		row = relation.length;
		// 일단 조합을 만들어보자.
		makeCombination(0, 0, relation);

		// 만든 조합중에서 최소성을 만족하늕지를 확인하자
		Collections.sort(list);
		// 최소성을 만족했으면 답을 출력하자.

		while (list.size() != 0) {
			int k = list.poll();
			answer += 1;
			for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
				int c = it.next();
				if ((k & c) == k) {
					it.remove();
				}
			}
		}
		return answer;
	}
}