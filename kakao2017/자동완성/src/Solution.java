import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
	Comparator<String> comp = new Comparator<String>() {
		public int compare(String s1, String s2) {
			int c = s1.compareTo(s2);
			if (c == 0) {
				return s1.length() - s2.length();
			}
			return c;
		}
	};

	public int solution(String[] words) {
		List<String> list = Arrays.asList(words);
		Collections.sort(list, comp);
		int answer = 0;
		int index = 0;
		while (index < list.size()) {
			String s = list.get(index);
			int stringCount = 1;
			for (int i = 0; i < s.length(); i++) {
				// 만약 없으면 그담은 loop를 안돌려야한다.
				boolean check = false;
				for (int j = index + 1; j < list.size(); j++) {
					if (s.charAt(i) == list.get(j).charAt(i)) {
						check = true;
						stringCount = i + 1;
						break;
					}
				}
				if(check) {
					break;
				}
			}
			answer += stringCount;
			index++;
		}
		return answer;
	}
}