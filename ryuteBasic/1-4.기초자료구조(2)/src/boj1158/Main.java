package boj1158;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		Iterator<Integer> it = list.iterator();
		int kcount = 1;
		sb.append("<");
		while(list.size() != 0) {
			while (it.hasNext()) {
				int num = it.next();
				if (kcount == k) {
					kcount = 1;
					sb.append(num+", ");
					it.remove();
				} else {
					kcount++;
				}
			}
			it = list.iterator();
		}
		String result = sb.substring(0, sb.length()-2);
		System.out.println(result + ">");
		sc.close();
	}

}
