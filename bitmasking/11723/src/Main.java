import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		int s = 0;
		
		for(int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int num = 0;
			if(input.length == 2) {
				 num = Integer.parseInt(input[1]);
			}
			switch(input[0]) {
			case "add":
				s = s | (1 << num);
				break;
			case "remove":
				s &= ~(1 << num);
				break;
			case "check":
				sb.append((s & (1 << num)) >> num);
				sb.append("\n");
				break;
			case "toggle":
				s ^= (1 << num);
				break;
			case "all":
				s = (s << 20) -1;
				break;
			case "empty":
				s = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
