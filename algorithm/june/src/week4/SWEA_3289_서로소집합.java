package week4;

import java.io.*;
import java.util.*;

public class SWEA_3289_서로소집합 {

	static int N, M;
	static int arr[];

	static int findboss(int a) {
		if (arr[a] == 0)
			return a;
		return findboss(arr[a]);
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
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (c == 0)
					setUnion(a, b);
				else if (c == 1) {
					if (findboss(a) == findboss(b))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			System.out.println("#" + t + " " + sb);
		}

	}

}
