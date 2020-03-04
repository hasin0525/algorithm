import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the triplets function below.
	static long triplets(int[] a, int[] b, int[] c) {
		long count = 0;
		a = Arrays.stream(a).distinct().sorted().toArray();
		b = Arrays.stream(b).distinct().sorted().toArray();
		c = Arrays.stream(c).distinct().sorted().toArray();

		long left = 0;
		long right = 0;
		int aIndex = 0;
		int cIndex = 0;
		for (int bnum : b) {
			while (aIndex < a.length && a[aIndex] <= bnum) {
				aIndex++;
				left++;
			}

			while (cIndex < c.length && c[cIndex] <= bnum) {
				cIndex++;
				right++;
			}
			count += left * right;
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] lenaLenbLenc = scanner.nextLine().split(" ");

		int lena = Integer.parseInt(lenaLenbLenc[0]);

		int lenb = Integer.parseInt(lenaLenbLenc[1]);

		int lenc = Integer.parseInt(lenaLenbLenc[2]);

		int[] arra = new int[lena];

		String[] arraItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lena; i++) {
			int arraItem = Integer.parseInt(arraItems[i]);
			arra[i] = arraItem;
		}

		int[] arrb = new int[lenb];

		String[] arrbItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenb; i++) {
			int arrbItem = Integer.parseInt(arrbItems[i]);
			arrb[i] = arrbItem;
		}

		int[] arrc = new int[lenc];

		String[] arrcItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenc; i++) {
			int arrcItem = Integer.parseInt(arrcItems[i]);
			arrc[i] = arrcItem;
		}

		long ans = triplets(arra, arrb, arrc);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
