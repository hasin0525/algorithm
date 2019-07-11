package boj1966;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Document implements Comparable<Document> {
		int index, importance;

		public Document(int index, int importance) {
			this.index = index;
			this.importance = importance;
		}

		@Override
		public int compareTo(Document o) {
			return o.importance - this.importance;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Document> queue;
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = sc.nextInt();
			int index = sc.nextInt();
			queue = new LinkedList<Document>();
			for (int j = 0; j < n; j++) {
				queue.add(new Document(j, sc.nextInt()));
			}
			int count = 1;
			while (true) {
				Document curDocument = queue.poll();
				// 뒤에 자신보다 중요성이 높은 것이 있으면 빼지않고 뒤로 보낸다.
				if (importanceCheck(queue, curDocument)) {
					// 중요성이 높은게 없으면
					if (curDocument.index == index) {
						System.out.println(count);
						break;
					}
					count++;
				} else {
					// 높은게 있으면
					queue.add(curDocument);
				}
			}
		}
		sc.close();
	}

	private static boolean importanceCheck(Queue<Document> queue, Document curDocument) {
		Iterator<Document> it = queue.iterator();
		while (it.hasNext()) {
			if (curDocument.importance < it.next().importance) {
				// 만약 중요성이 높은게 있으면 false
				return false;
			}
		}
		return true;
	}

}
