package week3;

import java.util.*;
import java.io.*;

public class BOJ_2644_촌수계산 {

	static int map[][];
	static int N, M, s, e, check;
	static boolean visit[];

	static void dfs(int level, int start) {

		if (start == e) {
			check = level;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && !visit[i]) {
				visit[i] = true;
				dfs(level + 1, i);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		check = -1;
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		} // input end

		dfs(0, s);
		System.out.println(check);
		
	}

}
