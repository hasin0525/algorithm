package boj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> hashset = new HashSet<Integer>();
		int n, m;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			hashset.add(Integer.parseInt(st.nextToken()));
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			if(hashset.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		/*
		int[] a, b;
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		b = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.parallelSort(a);
		
		for (int i = 0; i < m; i++) {
			if(Arrays.binarySearch(a, b[i]) < 0) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
		}
		*/
		
	}

}
