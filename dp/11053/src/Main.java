import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (num[i] > num[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		Arrays.parallelSort(dp);
		System.out.println(dp[n - 1]);
		sc.close();
	}
}
