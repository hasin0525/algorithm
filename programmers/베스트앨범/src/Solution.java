import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	class PlayInfo implements Comparable<PlayInfo> {
		int index, plays;

		public PlayInfo(int index, int plays) {
			this.index = index;
			this.plays = plays;
		}

		@Override
		public int compareTo(PlayInfo o) {
			int d = o.plays - this.plays;
			if (d == 0) {
				return this.index - o.index;
			}
			return d;
		}

	}

	// https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
	public LinkedHashMap<String, Integer> sortByValue(final HashMap<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;

	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> playCount = new HashMap<>();
		HashMap<String, LinkedList<PlayInfo>> playlist = new HashMap<>();
		int max = genres.length;

		for (int i = 0; i < max; i++) {
			if (!playCount.containsKey(genres[i])) {
				playCount.put(genres[i], plays[i]);
			} else {
				playCount.put(genres[i], playCount.get(genres[i]) + plays[i]);
			}
			if (!playlist.containsKey(genres[i])) {
				playlist.put(genres[i], new LinkedList<>());
			}
			playlist.get(genres[i]).add(new PlayInfo(i, plays[i]));
		}

		LinkedHashMap<String, Integer> sortedplayCount = sortByValue(playCount);
		for (Entry<String, LinkedList<PlayInfo>> e : playlist.entrySet()) {
			Collections.sort(e.getValue());
		}

		ArrayList<Integer> answer = new ArrayList<>();
		for (String genre : sortedplayCount.keySet()) {
			int count = 0;
			for (PlayInfo pi : playlist.get(genre)) {
				answer.add(pi.index);
				count += 1;
				if (count == 2) {
					break;
				}
			}
		}
		int[] result = new int[answer.size()];
		int answerSize = answer.size();
		for(int i = 0; i < answerSize; i++) {
			result[i] =  answer.get(i);
		}
		return result;
	}
}