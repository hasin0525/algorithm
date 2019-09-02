import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

class Solution {
	class Info {
		long start, end;

		public Info(long start, long end) {
			this.start = start;
			this.end = end;
		}

	}

	public int solution(String[] lines) {
		LinkedList<Info> time = new LinkedList<>();
		
		for (int i = 0; i < lines.length; i++) {
			String[] parsedTime = lines[i].split(" ");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
			LocalDateTime ldt = LocalDateTime.parse(parsedTime[0].concat(" ").concat(parsedTime[1]), dtf);
			ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Seoul"));
			long S = zdt.toInstant().toEpochMilli();
			long T = (long) (Double.parseDouble(parsedTime[2].replace("s", "")) * 1000);
			time.add(new Info(S - T + 1, S));
		}
		
		int answer = 0;
		
		for(Info t : time) {
			long start = t.start;
			long end = t.end;
			int startCnt = 0;
			int endedCnt = 0;
			for(Info l : time) {
                if(start <= l.end && start + 999 >= l.start) {
                    startCnt++;
                }
                if(end <= l.end && end + 999 >= l.start) {
                    endedCnt++;
                }
            }
			answer = startCnt > answer ? startCnt : answer;
			answer = endedCnt > answer ? endedCnt : answer;
		}
		return answer;
	}
}