package week4;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {

	static int N, M, check;
	static List<Integer>[] list;
	static boolean visit[];

	static void dfs(int level, int now) {

		if (check == 1)
			return;
		if (level >= 4) {
			check = 1;
			return;
		}

		for (int index : list[now]) {
			if (visit[index])
				continue;
			visit[index] = true;
			dfs(level + 1, index);
			visit[index] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		} // input end

		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			visit[i] = true;
			dfs(0, i);
			visit[i] = false;
		}
		System.out.println(check);

	}

}
