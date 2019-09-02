import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] solution(String msg) {
		ArrayList<Integer> list = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();
		char c = 'A';
		for (int i = 1; i <= 26; i++) {
			map.put(Character.toString(c++), i);
		}

		StringBuilder sb = new StringBuilder();
		int index = 0;
		String s = "";
		while (index < msg.length()) {
			sb.append(msg.charAt(index));
			s = sb.toString();
			if (!map.containsKey(s)) {
				list.add(map.get(s.substring(0, s.length() - 1)));
				map.put(s, map.size() + 1);
				sb.setLength(0);
				continue;
			}
			index++;
		}
		list.add(map.get(s));

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}