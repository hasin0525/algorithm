import java.util.ArrayList;

class Solution {
	public int[] solution(int n) {
		

		ArrayList<Integer>[] dp = new ArrayList[n + 1];
		dp[1] = new ArrayList<>();
		dp[1].add(0);

		for (int i = 2; i <= n; i++) {
			int plusLength = dp[i-1].size() + 1;
			dp[i] = new ArrayList<>();
			int index = 0;
			int insertValue = 0;
			for(int j = 0; j < plusLength; j++) {
				dp[i].add(insertValue);
				
				if(insertValue > 0) {
					insertValue-=1;
				}else {
					insertValue+=1;
				}
				
				if(index < dp[i-1].size()) {
					dp[i].add(dp[i-1].get(index));
					index+=1;
				}
			}
		}
		
		return dp[n].stream().mapToInt(i -> i).toArray();
	}
}