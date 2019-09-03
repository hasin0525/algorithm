import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		LocalTime start = LocalTime.parse("02:00");
		LocalTime end = LocalTime.parse("02:30");
		int time = (int) start.until(end, ChronoUnit.MINUTES);
		System.out.println(time);
		
	}

}
