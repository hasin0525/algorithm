import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	class FileInfo {
		String origin, head, number, tail;

		public FileInfo(String origin, String head, String number, String tail) {
			super();
			this.origin = origin;
			this.head = head;
			this.number = number;
			this.tail = tail;
		}
	}

	Comparator<FileInfo> comp = new Comparator<FileInfo>() {

		public int compare(FileInfo o1, FileInfo o2) {
			int c = o1.head.compareTo(o2.head);
			if (c == 0) {
				return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
			}
			return c;
		}

	};

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		ArrayList<FileInfo> list = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			Pattern p = Pattern.compile("([a-z .-]+)(\\d+)([\\da-z .-]*)");
			Matcher m = p.matcher(files[i].toLowerCase());
			while (m.find()) {
				String h = m.group(1);
				String n = m.group(2);
				String t = m.group(3);
				list.add(new FileInfo(files[i], h, n, t));
			}
		}
		Collections.sort(list, comp);
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).origin;
		}
		return answer;
	}
}