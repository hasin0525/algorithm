package boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cardList = new HashMap<Integer,Integer>();
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			int curKey = Integer.parseInt(input[i]); 
			if(cardList.containsKey(curKey)) {
				cardList.put(curKey,cardList.get(curKey)+1);
			}else {
				cardList.put(curKey,1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int curKey = Integer.parseInt(input[i]); 
			if(cardList.containsKey(curKey)) {
				sb.append(cardList.get(curKey)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}

}
