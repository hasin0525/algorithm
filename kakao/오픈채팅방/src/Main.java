import java.util.HashMap;

public class Main {
	public static String[] solution(String[] record) {
		HashMap<String, String> userList = new HashMap<>();
		int count = 0;
		String[] messageId = new String[100000];
		// 0은 나감 1은 들어옴
		int[] state = new int[100000]; 
		for(int i = 0; i < record.length; i++) {
			String[] splitedMessage = record[i].split(" ");
			switch(splitedMessage[0]) {
			case "Enter":
				userList.put(splitedMessage[1], splitedMessage[2]);
				messageId[count] = splitedMessage[1];
				state[count] = 1;
				count++;
				break;
			case "Leave":
				messageId[count] = splitedMessage[1];
				state[count] = 0;
				count++;
				break;
			case "Change":
				userList.replace(splitedMessage[1], splitedMessage[2]);
				break;
			}
		}
		String[] answer = new String[count];
		for(int i = 0; i < count; i++) {
			if(state[i] == 1) {
				answer[i] = userList.get(messageId[i]).concat("님이 들어왔습니다.");
			} else if(state[i] == 0) {
				answer[i] = userList.get(messageId[i]).concat("님이 나갔습니다.");
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(a);
	}

}
