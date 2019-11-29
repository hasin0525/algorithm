import java.util.Stack;

class Solution {
	public String solution(String number, int k) {
		int count = k;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < number.length(); i++) {
			char value = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < value && count - 1 >= 0) {
				stack.pop();
				count -=1;
			}
			stack.push(value);
		}
		for(int i = 0; i < count; i++) {
			stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}