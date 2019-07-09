package boj10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> treeSet = new TreeSet<Integer>();
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			treeSet.add(Integer.parseInt(input[i]));
		}
		Iterator<Integer> it = treeSet.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next()).append(" ");
		}
		System.out.println(sb);
	}

}
