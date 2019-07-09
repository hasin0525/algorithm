package boj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> stringList = new ArrayList<String>();
		for(int i =0;i<n;i++) {
			String input = br.readLine();
			if(!stringList.contains(input)) {
				stringList.add(input);
			}
		}
		Collections.sort(stringList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int compareValue = o1.length() - o2.length();
				if(compareValue == 0) {
					return o1.compareTo(o2);
				}else {
					return compareValue;
				}
			}
			
		});
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = stringList.iterator();
		while(it.hasNext()) {
			sb.append(it.next() + "\n");
		}
		System.out.println(sb);
	}

}
