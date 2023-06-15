package week3;

import java.util.*;
import java.io.*;

public class BOJ_1260_DFS와BFS {

	static int N, M, V;
	static int map[][];
	static int visit[];
	static Queue<Integer> q;

	static void dfs(int level) {

		visit[level] = 1;
		System.out.print(level + " ");

		for (int i = 1; i < N + 1; i++) {
			if (map[level][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}

	}

	static void bfs(int level) {

		q.add(level);
		visit[level] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && visit[i] == 0) {
					q.add(i);
					visit[i] = 1;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visit = new int[N + 1];
		q = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		} // input end

		dfs(V);
		visit = new int[N + 1];
		System.out.println();
		bfs(V);
	}

}
