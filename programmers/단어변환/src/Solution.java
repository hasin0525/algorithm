import java.util.LinkedList;
import java.util.Queue;

class Solution {
	boolean[] visited = new boolean[50];
	String[] words;
	String target;
	int answer = 0;
	Queue<String> q = new LinkedList<>();

	boolean isDiffer(String cur, String words) {
		int count = 0;
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != words.charAt(i)) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

	void bfs() {
		int count = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				String cur = q.poll();
				if (cur.equals(target)) {
					answer = count;
					return;
				}
				// next 값이 있는 지를 확인 있으면 방문했는지 확인후에 q에 넣는다.
				for (int j = 0; j < words.length; j++) {
					if (isDiffer(cur, words[j]) && !visited[j]) {
						visited[j] = true;
						q.add(words[j]);
					}
				}
			}
			count += 1;
		}
	}

	public int solution(String begin, String target, String[] words) {
		this.words = words;
		this.target = target;
		q.add(begin);
		bfs();
		return answer;
	}
}