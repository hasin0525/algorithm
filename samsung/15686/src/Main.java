import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class Info {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static Scanner sc = new Scanner(System.in);
	static LinkedList<Info> houselist;
	static LinkedList<Info> selectedChickenlist;
	static ArrayList<Info> chcikenlist;
	static int n, m, result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		houselist = new LinkedList<>();
		chcikenlist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int k = sc.nextInt();
				if (k == 1) {
					houselist.add(new Info(i, j));
				} else if (k == 2) {
					chcikenlist.add(new Info(i, j));
				}
			}
		}
		boolean[] selectedChicken = new boolean[chcikenlist.size()];
		makeCombination(0,0, selectedChicken);
		System.out.println(result);
	}

	private static void makeCombination(int index, int count, boolean[] selectedChicken) {
		if(index == chcikenlist.size() && count == m) {
			selectedChickenlist = new LinkedList<>();
			for(int i = 0; i < selectedChicken.length; i++) {
				if(selectedChicken[i]) {
					selectedChickenlist.add(chcikenlist.get(i));
				}
			}
			int exResult = 0;
			for(Info house : houselist) {
				int minValue = Integer.MAX_VALUE;
				for(Info chicken : selectedChickenlist) {
					minValue = Math.min(minValue, Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c));
				}
				exResult +=minValue;
			}
			
			result = Math.min(exResult, result);
			return;
		}
		if(index >= chcikenlist.size() || count > m) {
			return;
		}
		selectedChicken[index] = true;
		makeCombination(index+1,count+1,selectedChicken);
		selectedChicken[index] = false;
		makeCombination(index+1,count,selectedChicken);
	}
}
