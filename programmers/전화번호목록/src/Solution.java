import java.util.Arrays;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.parallelSort(phone_book);
		for(int i = 0; i < phone_book.length; i++) {
			for(int j = i+1; j < phone_book.length; j++) {
				if(phone_book[j].length() < phone_book[i].length()) {
					return true;
				} else if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
					return false;
				}
			}
		}
		return answer;
	}
}