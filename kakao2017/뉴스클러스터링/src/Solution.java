import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	public int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		// 문자열을 파싱한다.
		for (int i = 0; i < str1.length() - 1; i++) {
			if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
				String s = String.valueOf(str1.charAt(i)).concat(String.valueOf(str1.charAt(i + 1)));
				if (map1.containsKey(s)) {
					map1.replace(s, map1.get(s) + 1);
				} else {
					map1.put(s, 1);
				}
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
				String s = String.valueOf(str2.charAt(i)).concat(String.valueOf(str2.charAt(i + 1)));
				if (map2.containsKey(s)) {
					map2.replace(s, map2.get(s) + 1);
				} else {
					map2.put(s, 1);
				}
			}
		}
		// 공집합인 경우는?
		int a = 0;
		int b = 0;
		// 교집합을 구한다.
		for (Entry<String, Integer> e : map1.entrySet()) {
			if (map2.containsKey(e.getKey())) {
				// 더 작은 value를 더해준다.
				if (map2.get(e.getKey()) == e.getValue()) {
					a += e.getValue();
				} else if (map2.get(e.getKey()) > e.getValue()) {
					a += e.getValue();
				} else {
					a += map2.get(e.getKey());
				}
			}
		}
		// 합집합을 구한다.
		for (Entry<String, Integer> e : map2.entrySet()) {
			if (map1.containsKey(e.getKey())) {
				// 만약 가지고 있으면 더 큰 값으로 변경한닫.
				if (e.getValue() > map1.get(e.getKey())) {
					map1.replace(e.getKey(), e.getValue());
				}
			} else {
				map1.put(e.getKey(), e.getValue());
			}
		}
		for (Entry<String, Integer> e : map1.entrySet()) {
			b += e.getValue();
		}

		if(a == 0 && b == 0) {
			answer = 65536;
		} else {
			answer = (int)(((float)a / b) * 65536);
		}
		
		
		return answer;
	}
}