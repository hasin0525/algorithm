import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, k;
	static int[] value;

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();

		value = new int[n];

		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
			dp[value[i]]++;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= i / 2; j++) {
				if (j == i - j) {
					if (dp[j] * dp[i - j] == 1) {
						dp[i]++;
					} else {
						dp[i] += (dp[j] * dp[i - j]) / 2;
					}
				} else {
					dp[i] += dp[j] * dp[i - j];
				}
			}
		}
		System.out.println(dp[3]);
		System.out.println(dp[k]);
	}

}
