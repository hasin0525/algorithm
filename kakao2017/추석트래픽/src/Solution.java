import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Solution {

	public int solution(String[] lines) {
		int answer = 0;
		ZonedDateTime[][] dateList = new ZonedDateTime[lines.length][2];
		// 라인을 전부 꺼내서 변경 후 리스트에 넣는다.
		ZonedDateTime start =  ZonedDateTime.parse("2016-09-15 00:00:00.000 KST", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z"));
		for (int i = 0; i < lines.length; i++) {
			String parse = lines[i].substring(0, 24).concat("KST");
			String parse2 = lines[i].substring(24,25);
            String parse3 = "0";
            if(lines[i].charAt(25) == '.'){
                parse3 = lines[i].substring(26,lines[i].length()-1);
            }
			dateList[i][1] = ZonedDateTime.parse(parse, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z"));
			dateList[i][0] =  dateList[i][1].minusSeconds(Long.parseLong(parse2)).minusNanos(Long.parseLong(parse3)*1000000).plusNanos(1000000);
		}
		for(int i = 1; i <= 3; i++) {
			ZonedDateTime end = start.plusSeconds(i);
			int count = 0;
			for (int j = 0; j < lines.length; j++) {
				if((dateList[j][0].compareTo(start) == 0 || dateList[j][0].compareTo(start) < 0)  && (dateList[j][1].compareTo(start) == 0 || dateList[j][1].compareTo(start) > 0)) {
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}
}