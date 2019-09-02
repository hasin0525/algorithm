public class Main {
	public static char[] make(int num, int n) {
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			int mod = num % n;
			sb.append(mod < 10 ? mod : Integer.toString(mod).toUpperCase());
			num /= n;
		}
		return sb.reverse().toString().toCharArray();
	}
	
	public static void main(String[] args) {
		
		char c = 'A';
	
		
		
	}

}
