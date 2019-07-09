package boj11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static class Coordinate implements Comparable<Coordinate> {
		int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o) {
			int compareValue = this.x - o.x;
			if(compareValue == 0) {
				return this.y - o.y;
			}else {
				return compareValue;
			}
			
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Coordinate> coordinateList = new LinkedList<Coordinate>();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			coordinateList.add(new Coordinate(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
		}
		Collections.sort(coordinateList);
		Iterator<Coordinate> it = coordinateList.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			Coordinate coordinate = it.next();
			sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
		}
		System.out.println(sb);
	}

}
