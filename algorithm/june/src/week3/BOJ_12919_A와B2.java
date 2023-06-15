package week3;

import java.io.*;
import java.util.*;

public class BOJ_12919_A와B2 {

	static String S, T;
	static int check;

	// dfs 로 재귀 타는 곳
	static void dfs(String word) {

		if (check == 1)
			return;
		if (word.length() == S.length()) {
			if (word.equals(S))
				check = 1;
			return;
		}

		if (word.charAt(0) == 'B') {
			String substring = word.substring(1); // 1번 인덱스부터 자르기
			StringBuffer sb = new StringBuffer(substring);
			String reverse = sb.reverse().toString();
			dfs(reverse);
		}
		if (word.charAt(word.length() - 1) == 'A') {
			dfs(word.substring(0, word.length() - 1));
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		check = 0;
		// input end
		dfs(T);

		System.out.println(check);

	}

}
