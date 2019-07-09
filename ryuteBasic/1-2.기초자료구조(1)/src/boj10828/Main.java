package boj10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < n;i++) {
			String input = sc.nextLine();
			String[] splitedInput = input.split(" ");
			switch(splitedInput[0]) {
			case "push":
				stack.push(Integer.parseInt(splitedInput[1]));
				break;
			case "pop":
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println((stack.isEmpty() ? 1 : 0));
				break;
			case "top":
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.peek());
				}
				break;
			}
		}
	}

}
