import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

class Solution {
	public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, LinkedList<String>> clotheslist = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if (!clotheslist.containsKey(clothes[i][1])) {
				clotheslist.put(clothes[i][1], new LinkedList<>());
			}
			clotheslist.get(clothes[i][1]).add(clothes[i][0]);
		}
		for(Entry<String, LinkedList<String>> e : clotheslist.entrySet()) {
			answer *= (e.getValue().size() + 1);
		}
		return answer - 1;
	}
}