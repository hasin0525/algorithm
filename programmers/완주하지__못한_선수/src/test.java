import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 1);
		System.out.println(map.entrySet().contains("a"));

	}

}
