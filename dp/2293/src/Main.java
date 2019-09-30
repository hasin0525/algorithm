import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			dp[sc.nextInt()] = 1;
		}
		for (int i = 1; i <= k; i++) {
			dp[i] = dp[i-1];
			
		}
		System.out.println(dp[k]);
		sc.close();
	}

}
