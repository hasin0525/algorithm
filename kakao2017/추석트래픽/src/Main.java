

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		String s = "2016-09-15 20:59:57.421 0.351s";
		String[] ss = s.split(" ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime S = LocalDateTime.parse(ss[0].concat(" ").concat(ss[1]), dtf);
		ZonedDateTime zdt = S.atZone(ZoneId.of("Asia/Seoul"));
        //long endedDtm = dt.parse(arr[0]+" "+arr[1]).getTime();
        //long proceDtm = (long)(Double.parseDouble(arr[2].replace("s", ""))*1000); 
		
		System.out.println(zdt.toInstant().toEpochMilli());
	}

}
