import java.util.HashMap;
import java.util.Map;

class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();

		for (String p : participant) {
			if(map.computeIfPresent(p, (String key, Integer value) -> value+=1) == null) {
				map.put(p, 1);
			}
		}

		for (String c : completion) {
			if(map.computeIfPresent(c, (String key, Integer value) -> value-=1) == 0) {
				map.remove(c);
			}
		}
		String answer = null;
		for(String key : map.keySet()) {
			answer = key;
		}
		return answer;
	}
}