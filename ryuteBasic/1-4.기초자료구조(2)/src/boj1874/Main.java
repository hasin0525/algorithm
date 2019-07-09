package boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int maxValue = 0;
		
		for(int i = 0; i < n; i++) {
			int inputValue = Integer.parseInt(br.readLine());
			if(inputValue > maxValue) {
				for(int j = maxValue; j < inputValue; j++) {
					stack.push(j+1);
					sb.append("+\n");
				}
			}else if(stack.peek() != inputValue) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			stack.pop();
			sb.append("-\n");
			if(inputValue > maxValue) {
				maxValue = inputValue;
			}
		}
		System.out.println(sb);
	}

}
