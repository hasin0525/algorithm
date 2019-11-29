import java.util.Arrays;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		Arrays.sort(lost);
		Arrays.sort(reserve);
		boolean[] lostCheck = new boolean[lost.length];
        boolean[] reserveCheck = new boolean[reserve.length];
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    reserveCheck[i] = true;
                    lostCheck[j] = true;
                    answer += 1;
                    break;
                }
            }
        }
        
		for (int i = 0; i < lost.length; i++) {
			if(lostCheck[i]) {
				continue;
			}
			for (int j = 0; j < reserve.length; j++) {
				if (reserveCheck[j]) {
					continue;
				} else if (lost[i] - reserve[j] == -1 || lost[i] - reserve[j] == 1) {
					reserve[j] = 0;
					answer+=1;
					break;
				}
			}
		}

		return answer;
	}
}