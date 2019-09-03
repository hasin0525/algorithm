import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
	class Music {
		int time;
		String name;

		public Music(int time, String name) {
			this.time = time;
			this.name = name;
		}

	}

	Comparator<Music> comp = new Comparator<Music>() {
		public int compare(Music m1, Music m2) {
			return m2.time - m1.time;
		}
	};

	public String solution(String m, String[] musicinfos) {
		LinkedList<Music> list = new LinkedList<>();
		m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");

		for (int i = 0; i < musicinfos.length; i++) {
			String[] musicinfo = musicinfos[i].split(",");
			musicinfo[3] = musicinfo[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");
			LocalTime start = LocalTime.parse(musicinfo[0]);
			LocalTime end = LocalTime.parse(musicinfo[1]);
			int time = (int) start.until(end, ChronoUnit.MINUTES);

			// 악보를 시간비례로 만들어준다.
			String sheet = "";
			if (time <= musicinfo[3].length()) {
				sheet = musicinfo[3].substring(0, time);
			} else {
				sheet = musicinfo[3];
				int plusLength = time - musicinfo[3].length();
				while (plusLength > musicinfo[3].length()) {
					sheet = sheet.concat(musicinfo[3]);
					plusLength -= musicinfo[3].length();
				}
				sheet = sheet.concat(musicinfo[3].substring(0, plusLength));
			}
			// 여기서 m 이 있는지를 검색한다.
			if (sheet.contains(m)) {
				list.add(new Music(time, musicinfo[2]));
			}
		}

		String answer = "";
		Collections.sort(list, comp);
		if (list.size() == 0) {
			answer = "(None)";
		} else {
			answer = list.getFirst().name;
		}
		return answer;
	}
}