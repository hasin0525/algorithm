import java.util.LinkedList;

class Solution {

	public String[] make(int a, int n) {
		LinkedList<String> list = new LinkedList<>();

		while (a >= n) {
			int mod = a % n;
			String s = "";
			if (mod < 10) {
				s = Integer.toString(mod);
				
			} else {
				s = Integer.toHexString(mod).toUpperCase();
			}
			list.addFirst(s);
			a = a / n;
		}
		if (a < 10) {
			list.addFirst(Integer.toString(a));
			
		} else {
			list.addFirst(Integer.toHexString(a).toUpperCase());
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	public String solution(int n, int t, int m, int p) {
		String answer = "";
		LinkedList<String> save = new LinkedList<>();
		int start = 0;
		int index = 0;
		int order = 1;
		String[] num = make(start, n);
		while(true) {
			if(index == num.length) {
				index = 0;
				start += 1;
				num = make(start,n);
			}

			if(order == p) {
				save.add(num[index]);
			}
			order++;
			index++;
			if(save.size() == t) {
				break;
			}
			if(order == m+1) {
				order = 1;
			}
		}
		answer = String.join("", save);
		return answer;
	}
}