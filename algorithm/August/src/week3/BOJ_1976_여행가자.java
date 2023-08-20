package week3;

import java.util.*;
import java.io.*;

public class BOJ_1976_여행가자 {

	static int arr[];
	static int N, M;

	static int findboss(int a) {
		if (arr[a] == 0)
			return a;
		else
			return arr[a] = findboss(arr[a]);
	}

	static void setUnion(int a, int b) {
		int finda = findboss(a);
		int findb = findboss(b);
		if (finda == findb)
			return;
		arr[findb] = finda;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr = new int[1001];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1)
					if (findboss(i) != findboss(j)) {
						setUnion(i, j);
					}
			}
		} // input end

		String str[] = br.readLine().split(" ");
		
		String answer = "YES";
		for (int i = 1; i < str.length; i++) {
			int a = Integer.parseInt(str[i - 1]);
			int b = Integer.parseInt(str[i]);
			if (findboss(a) != findboss(b)) {
				answer = "NO";
				// System.out.println(a + " " + b);
				break;
			}
		}
		System.out.println(answer);
	}

}
