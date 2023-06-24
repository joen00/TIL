package week4;

import java.io.*;
import java.util.*;

public class BOJ_1249_보급로 {

	static int N, ans;
	static int map[][];
	static int D[][];
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class node {
		int x, y, w;

		public node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

	}

	static void bfs() {

		Queue<node> q = new ArrayDeque<>();
		q.add(new node(0, 0, map[0][0]));
		while (!q.isEmpty()) {
			node cur = q.poll();

			if (cur.x == N - 1 && cur.y == N - 1) {
				ans = D[N - 1][N - 1];
			}
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (D[dx][dy] > map[dx][dy] + cur.w) {
					D[dx][dy] = map[dx][dy] + cur.w;
					q.add(new node(dx, dy, D[dx][dy]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			D = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					D[i][j] = Integer.MAX_VALUE;
				}
			} // input end

			bfs();
			System.out.println("#" + t + " " + ans);

		}

	}

}
