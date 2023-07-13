package week2;

import java.io.*;
import java.util.*;

public class PRO_귤고르기 {

	static public int solution(int k, int[] tangerine) {
		int answer = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < tangerine.length; i++) {
			if (map.containsKey(tangerine[i])) {
				int value = map.get(tangerine[i]);
				value = value + 1;
				map.put(tangerine[i], value);
			} else
				map.put(tangerine[i], 1);
		}

		List<Integer> valueList = new ArrayList<>(map.values());
		Collections.sort(valueList, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < valueList.size(); i++) {
			// System.out.println(valueList.get(i));
			if (sum == k)
				break;
			else if (sum + valueList.get(i) <= k) {
				sum = sum + valueList.get(i);
				answer++;
			} else {
				sum = k;
				answer++;
			}
		}
		//System.out.println(sum + " " + k);
		
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 5, 4, 5, 2, 3 };
		solution(4, a);
	}

}
