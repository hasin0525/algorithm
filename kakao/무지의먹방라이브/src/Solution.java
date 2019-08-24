import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Info {
	int idx, value;

	public Info(int idx, int value) {
		super();
		this.idx = idx;
		this.value = value;
	}	
}

class Solution {
	
	Comparator<Info> time = new Comparator<Info>() {
		public int compare(Info a, Info b) {
			return a.value - b.value;
		}
	};
	
	Comparator<Info> index = new Comparator<Info>() {
		public int compare(Info a, Info b) {
			return a.idx - b.idx;
		}
	};
	
	public int solution(int[] food_times, long k) {
		List<Info> list = new LinkedList<>();
		int n = food_times.length;
		for (int i = 0; i < n; i++) {
			list.add(new Info(i + 1, food_times[i]));
		}
		Collections.sort(list, time);
		
		int pretime = 0;
		int a = 0;
		for(Info i : list) {
			long diff = i.value - pretime;
			if(diff != 0) {
				long spend = diff * n;
				if (spend <= k) {
					k-= spend;
					pretime = i.value;
				} else {
					k %= n;
					list.subList(a, food_times.length).sort(index);
					return list.get(a+(int)k).idx;
				}
			}
			++a;
			--n;
		}
		
		return -1;
	}
}