package week5;

public class PRO_큰수만들기 {

	public String solution(String number, int k) {

		StringBuilder answer = new StringBuilder("");
		int len = number.length() - k;
		int start = 0;
		while (start < number.length() && answer.length() != len) {
			int max = 0;
			for (int j = start; j < k + answer.length() + 1; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					start = j + 1;
				}
			}
			answer.append(Integer.toString(max));
		}

		return answer.toString();
	}

}
