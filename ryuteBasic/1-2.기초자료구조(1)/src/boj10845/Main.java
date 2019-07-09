package boj10845;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Deque<Integer> queue = new LinkedList<Integer>();
		for(int i = 0 ; i < n;i++) {
			String input = sc.nextLine();
			String[] splitedInput = input.split(" ");
			switch(splitedInput[0]) {
			case "push":
				queue.add(Integer.parseInt(splitedInput[1]));
				break;
			case "pop":
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.pollFirst());
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println((queue.isEmpty() ? 1 : 0));
				break;
			case "front":
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.peekFirst());
				}
				break;
			case "back":
				System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
				break;
			}
		}
	}

}
