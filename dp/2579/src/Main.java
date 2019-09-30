import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		int[][] dp = new int[n][2];
		for(int i = 0; i < n;  i++){
			s[i] = sc.nextInt();
		}
		
		dp[0][0] = s[0];
		dp[0][1] = 0;		
		dp[1][0] = s[1];
		dp[1][1] = s[0] + s[1];
				
		for(int i = 2; i < n; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + s[i];
			dp[i][1] = dp[i-1][0] + s[i];
		}
		System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
		sc.close();

	}

}
