package boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			char[] stack = br.readLine().toCharArray();
			int top = -1;
			int stackLength = stack.length;
			for(int j = 0; j < stackLength; j++) {
				if(stack[j] == '(') {
					top++;
				}else {
					top--;
					if(top<-1) break;
				}
			}
			
			if(top == -1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
