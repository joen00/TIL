package week4;

import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char arr[];

	static void dfs(int level, int start, String word, int mo, int za) {

		if (level == L) {
			if (mo >= 1 && za >= 2) {
				System.out.println(word);
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				dfs(level + 1, i + 1, word + arr[i], mo + 1, za);
			else
				dfs(level + 1, i + 1, word + arr[i], mo, za + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		} // input end
		Arrays.sort(arr);
		dfs(0, 0, "", 0, 0);
		
	}

}
