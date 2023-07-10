package week2;

import java.io.*;
import java.util.*;

public class PRO_뒤에있는큰수찾기 {

	static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		Stack<Integer> s = new Stack<>();
		s.push(0);

		for (int i = 1; i < numbers.length; i++) {
			while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
				answer[s.pop()] = numbers[i];
			}
			s.push(i);
		}

		while (!s.isEmpty()) {
			answer[s.pop()] = -1;
		}

		return answer;
	}

	public static void main(String[] args) {

		int[] numbers = { 9, 1, 5, 3, 6, 2 };
		solution(numbers);

	}

}
