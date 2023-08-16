package week3;

import java.util.*;
import java.io.*;

public class BOJ_2922_즐거운단어 {

	static int path[];
	static String str;
	static String arr[];
	static int indexarr[];
	static int size;
	static long answer, flag;

	// 계산 해주기
	static void cal() {

		String s[] = arr;
		int mo = 0;
		int za = 0;

		for (int i = 0; i < size; i++) {
			if (path[i] == 0) {
				s[indexarr[i]] = "B";
				za++;
			} else if (path[i] == 1) {
				s[indexarr[i]] = "A";
				mo++;
			}
		}

		for (int i = 0; i <= str.length() - 3; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				if (s[i + j].equals("A") || s[i + j].equals("E") || s[i + j].equals("I") || s[i + j].equals("O")
						|| s[i + j].equals("U")) {
					sum++;
				}
			}

			if (sum == 3 || sum == 0)
				return;
		}

		long sum = 1;
		long plag = flag;
		int t = 0;
		if (plag == 0 && za == 0)
			return;
		else {
			sum *= (long) Math.pow(21, za) - (long) Math.pow(20, za);
			if (mo != 0)
				sum *= (int) Math.pow(5, mo);
		}

		// System.out.println(Arrays.toString(s));
		answer = answer + sum;

	}

	static void dfs(int level) {

		if (level == size) {

			cal();
			return;
		}

		for (int i = 0; i < 2; i++) {
			path[level] = i;
			dfs(level + 1);
			path[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		arr = str.split("");
		indexarr = new int[str.length()];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("_")) {
				indexarr[size] = i;
				size++;
			}

			if (arr[i].equals("L")) {
				flag++;
			}
		}
		path = new int[size];

		// input end
		// 26 21 5
		dfs(0);

		System.out.print(answer); // 26 ->
	}

}
