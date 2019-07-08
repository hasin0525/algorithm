package boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int inputLength = input.length();
		
		Stack<String> stack = new Stack<String>();
		Stack<String> backStack = new Stack<String>();
		for (int i = 0; i < inputLength; i++) {
			stack.push(String.valueOf(input.charAt(i)));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			String[] inputs = input.split(" ");
			switch (inputs[0]) {
			case "L":
				if(!stack.isEmpty()) {
					backStack.push(stack.pop());
				}
				break;
			case "D":
				if(!backStack.isEmpty()) {
					stack.push(backStack.pop());
				}
				break;
			case "B":
				if(!stack.isEmpty()) {
					stack.pop();
				}
				break;
			case "P":
				stack.push(inputs[1]);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!backStack.isEmpty()) {
			stack.push(backStack.pop());
		}
		for(String s : stack) {
			sb.append(s);
		}
		System.out.println(sb);
	}

}
