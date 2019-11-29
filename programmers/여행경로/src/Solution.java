import java.util.Arrays;
import java.util.Comparator;

class Solution {
	String[] result;
	boolean check;
	public String[] solution(String[][] tickets) {
		result = new String[tickets.length+1];
		Arrays.parallelSort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}

		});
		
		int index = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				boolean[] isVisited = new boolean[tickets.length];
				index = i;
				String[] answer = new String[tickets.length+1];
				answer[0] = "ICN";
				isVisited[index] = true;
				dfs(1, index, 1, isVisited, answer, tickets);
				if(check) {
					break;
				}
			}
		}
		
		
		return result;
	}

	private void dfs(int count, int index, int answerIndex, boolean[] isVisited, String[] answer,String[][] tickets) {
		if(check) {
			return;
		}
		answer[answerIndex] = tickets[index][1];
		if(count == tickets.length) {
			check = true;
			result = Arrays.copyOf(answer, answer.length);
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if(!isVisited[i] && tickets[i][0].equals(tickets[index][1])) {
				isVisited[i]  = true;
				dfs(count+1, i, answerIndex+1, isVisited, answer, tickets);
				isVisited[i]  = false;
			}
		}
	}
}