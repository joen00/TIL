package week3;

import java.io.*;
import java.util.*;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int N, MIN;
	static int S[], B[];
	static int path[];

	public static void dfs(int start, int level) {

		if (level > 0) {
			
			int Ssum = 1;
			int Bsum = 0;
			for (int i = 0; i < N; i++) {
				if (path[i] != -1) {
					Ssum = Ssum * S[path[i]];
					Bsum = Bsum + B[path[i]];
				}
			}
			MIN = Math.min(MIN, Math.abs(Ssum - Bsum));
		}

		for (int i = start; i < N; i++) {
			path[i] = i;
			dfs(i + 1, level + 1);
			path[i] = -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N];
		B = new int[N];
		path = new int[N];
		MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			path[i] = -1;
		} // input end

		dfs(0, 0);
		System.out.println(MIN);
	}

}
