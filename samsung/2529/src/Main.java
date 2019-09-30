import java.util.Scanner;

public class Main {
	static int k;
	static Scanner sc = new Scanner(System.in);
	static String[] Inequality;
	static StringBuffer sb = new StringBuffer();
	static long max = Long.MIN_VALUE, min = Long.MAX_VALUE; 
	static String maxResult, minResult;
	public static boolean isRight(int[] selectNums) {
		for (int i = 0; i < k; i++) {
			if (Inequality[i].equals("<")) {
				if (selectNums[i] < selectNums[i + 1] == false) {
					return false;
				}
			} else {
				if (selectNums[i] > selectNums[i + 1] == false) {
					return false;
				}
			}
		}
		return true;
	}

	public static void makePermutation(int index, int[] selectNums, boolean[] selected) {
		if (index == k + 1) {
			if (isRight(selectNums)) {
				for(int n : selectNums) {
					sb.append(n);
				}
				Long sum = Long.parseLong(sb.toString());
				if(max < sum) {
					max = sum;
					maxResult = sb.toString();
				}
				if(min > sum) {
					min = sum;
					minResult = sb.toString();
				}
				sb.setLength(0);
			}

			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!selected[i]) {
				selected[i] = true;
				selectNums[index] = i;
				makePermutation(index + 1, selectNums, selected);
				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		k = sc.nextInt();
		sc.nextLine();
		Inequality = new String[k];
		Inequality = sc.nextLine().split(" ");
		// 조합을 만든다.
		int[] selectNums = new int[k + 1];
		boolean[] selected = new boolean[10];
		makePermutation(0, selectNums, selected);
		System.out.println(maxResult);
		System.out.println(minResult);
	}

}
