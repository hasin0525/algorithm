import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int inequalityLength;
	static String[] numArray;
	static String[] inequalityArray;
	static boolean[] select;
	static String min = "", max = "";

	public static void main(String[] args) {
		inequalityLength = sc.nextInt();
		sc.nextLine();

		numArray = new String[inequalityLength + 1];
		select = new boolean[10];
		inequalityArray = new String[inequalityLength];
		for (int i = 0; i < inequalityLength; i++) {
			inequalityArray[i] = sc.next();
		}

		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void permutation(int curIndex) {
		if (curIndex >= numArray.length) {
			// 부등호 검사
			for (int i = 0; i < inequalityLength; i++) {
				if (inequalityArray[i].contentEquals("<") && numArray[i].compareTo(numArray[i + 1]) > 0) {
					return;
				} else if (inequalityArray[i].contentEquals(">") && numArray[i].compareTo(numArray[i + 1]) < 0) {
					return;
				}
			}
			// 최대값 최소값 갱신
			String joinNum = String.join("", numArray);
			if (max.contentEquals(""))
				max = joinNum;
			if (min.contentEquals(""))
				min = joinNum;

			if (joinNum.compareTo(max) > 0)
				max = joinNum;
			if (joinNum.compareTo(min) < 0)
				min = joinNum;
			return;
		}

		for (int i = 0; i < select.length; i++) {
			if (!select[i]) {
				select[i] = true;
				numArray[curIndex] = String.valueOf(i);
				permutation(curIndex + 1);
				select[i] = false;
			}
		}
	}

}
