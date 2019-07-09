package boj10866;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i = 0 ; i < n;i++) {
			String input = sc.nextLine();
			String[] splitedInput = input.split(" ");
			switch(splitedInput[0]) {
			case "push_front":
				deque.addFirst(Integer.parseInt(splitedInput[1]));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(splitedInput[1]));
				break;
			case "pop_front":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.pollFirst());
				}
				break;
			case "pop_back":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.pollLast());
				}
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				System.out.println((deque.isEmpty() ? 1 : 0));
				break;
			case "front":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.peekFirst());
				}
				break;
			case "back":
				System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
				break;
			}
		}
		sc.close();
	}

}
