import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int n, result;
	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> s = new Stack<Integer>();
	static Stack<Integer> o = new Stack<Integer>();
	static ArrayList<Integer> number = new ArrayList<Integer>();
	static ArrayList<Character> operator = new ArrayList<Character>();

	static void cacul(Character operator, int curIndex) {
		switch (operator.charValue()) {
		case '+':
			s.push(s.pop() + number.get(curIndex+1));
			break;
		case '-':
			s.push(s.pop() - number.get(curIndex+1));
			break;
		case '*':
			s.push(s.pop() * number.get(curIndex+1));
			break;
		}
	}

	static void backtracking(int curIndex, boolean bracket) {
		if (curIndex >= n) {
			for (Integer a : s) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		if (bracket) {
			s.push(number.get(curIndex));
		}
		if (n == 1) {
			return;
		}
		if (bracket) {
			// 괄호를 치는 경우랑 안치는 경우 다 가능
			cacul(operator.get(curIndex), curIndex);
			backtracking(curIndex + 1, false);
			s.pop();
			s.push(number.get(curIndex));
			o.push(operator.get(curIndex));
			backtracking(curIndex + 2, true);
		} else {
			// 괄호를 칠수 없는 경우만 실행
			s.push(arr[curIndex]);
			s.push(arr[curIndex + 1]);
			backtracking(curIndex + 2, true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (input.charAt(i) - '0' > 10) {
				operator.add(input.charAt(i));
			} else {
				number.add(input.charAt(i) - '0');
			}
		}
		backtracking(1, true);
		// System.out.println(s.firstElement());
	}

}
