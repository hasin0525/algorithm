package boj1026;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += (a[i] * b[n-i-1]);
		}
		/*
		Arrays.sort(b, Collections.reverseOrder());
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += (a[i] * b[i]);
		}
		*/
		System.out.println(s);
		sc.close();
	}

}
