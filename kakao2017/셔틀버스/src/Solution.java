import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		LocalTime[][] bus = new LocalTime[n][m + 1];
		int[] busSize = new int[n];

		LinkedList<LocalTime> q = new LinkedList<>();
		for (String tt : timetable) {
			if(!tt.substring(0,2).equals("24")) {
				q.add(LocalTime.parse(tt));
			}
		}
		Collections.sort(q);

		LocalTime busTime = LocalTime.of(9, 0);

		for (int i = 0; i < n; i++) {
			bus[i][0] = busTime;
			// 여기서 승객들을 태운다.
			int count = 1;
			while (!q.isEmpty()) {
				if (busTime.isAfter(q.peek()) || busTime.equals(q.peek())) {
					if (busSize[i] < m) {
						bus[i][count++] = q.poll();
						busSize[i]++;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			busTime = busTime.plusMinutes(t);
		}

		// 여기서 버스 리스트의 뒤에서부터 확인한다.
		for (int i = n - 1; i >= 0; i--) {
			if (busSize[i] >= m) {
				answer = bus[i][busSize[i]].minusMinutes(1).toString();
				break;
			} else {
				answer = bus[i][0].toString();
				break;
			}
		}

		return answer;
	}
}