import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int n, result = Integer.MIN_VALUE;
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Integer> num;
	static LinkedList<Character> operator;

	public static int cacul(char o, int n1, int n2) {
		switch (o) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		}
		return n1 * n2;
	}

	public static void go(int r) {
		if (num.size() == 0) {
			result = Math.max(result, r);
			return;
		}
		int a = num.poll();
		char o = operator.poll();
		int nr = cacul(o, r, a);
		go(nr);
		if(num.size()!=0) {
			int b = num.poll();
			char o2 = operator.poll();
			int nr2 = cacul(o, r, cacul(o2,a,b));
			go(nr2);
			operator.addFirst(o2);
			num.addFirst(b);
		}
		operator.addFirst(o);
		num.addFirst(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = sc.nextInt();
		sc.nextLine();
		num = new LinkedList<>();
		operator = new LinkedList<>();
		String input = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				operator.add(input.charAt(i));
			} else {
				num.add(input.charAt(i) - '0');
			}
		}
		int r = num.poll();
		go(r);
		if(num.size() != 0) {
			int r2 = num.poll();
			go(cacul(operator.poll(), r, r2));
		}
		System.out.println(result);
	}

}
