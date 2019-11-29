import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(int[] money) {
		int length = money.length;

		int[] dp = new int[length];
		dp[0] = money[0];
		dp[1] = money[0];
		dp[2] = money[0];
		for (int i = 3; i < length; i++) {
			dp[i] = Math.max(dp[i - 2] + money[i-1], dp[i - 1]);
		}
		
		int[] dp2 = new int[length];
		dp2[1] = money[1];
		for(int i = 2; i < length; i++) {
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
		}
		
		return Math.max(dp[length-1], dp2[length-1]);
	}
}
