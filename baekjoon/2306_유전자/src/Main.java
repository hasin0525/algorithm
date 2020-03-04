import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char[] dna = new char[500];
		int[][] dp = new int[500][500];

		String input = sc.nextLine();
		for (int i = 0; i < input.length(); i++) {
			dna[i] = input.charAt(i);
		}

		int dnaLength = input.length();

		for (int size = 1; size < dnaLength; size++) {
			for (int start = 0; start + size < dnaLength; start++) {
				int end = start + size;

				if ((dna[start] == 'a' && dna[end] == 't') || (dna[start] == 'g' && dna[end] == 'c')) {
					dp[start][end] = dp[start + 1][end - 1] + 2;
				}

				for (int mid = start; mid < end; mid++) {
					dp[start][end] = Math.max(dp[start][end], dp[start][mid] + dp[mid + 1][end]);
				}
			}
		}

		System.out.println(dp[0][dnaLength - 1]);
	}

}
