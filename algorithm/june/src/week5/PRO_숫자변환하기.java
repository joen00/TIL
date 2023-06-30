package week5;

import java.io.*;
import java.util.*;

public class PRO_숫자변환하기 {

	static public int solution(int x, int y, int n) {
		int answer = 0;

		int arr[] = new int[y + 1];

		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[x] = 0;
		for (int i = x; i <= y; i++) {
			if (arr[i] == Integer.MAX_VALUE)
				continue;
			if (i * 2 <= y)
				arr[i * 2] = Math.min(arr[i] + 1, arr[i * 2]);
			if (i * 3 <= y)
				arr[i * 3] = Math.min(arr[i] + 1, arr[i * 3]);
			if (i + n <= y)
				arr[i + n] = Math.min(arr[i] + 1, arr[i + n]);
		}

		// System.out.println(arr[y]);
		if (arr[y] == Integer.MAX_VALUE)
			answer = -1;
		else
			answer = arr[y];
		return answer;
	}

	public static void main(String[] args) {

		System.out.println(solution(10, 40, 5));
	}

}
