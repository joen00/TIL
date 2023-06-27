package week5;

import java.io.*;
import java.util.*;

public class BOJ_2636_치즈 {

	static int N, M, time, last;
	static int map[][];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int size() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	static void melt() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}

	}

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {
		Queue<node> q = new ArrayDeque<>();
		q.add(new node(0, 0));
		boolean visit[][] = new boolean[N][M];
		visit[0][0] = true;
		while (!q.isEmpty()) {
			node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (map[dx][dy] == 0 && !visit[dx][dy]) {
					q.add(new node(dx, dy));
					visit[dx][dy] = true;
				} else if (map[dx][dy] == 1)
					map[dx][dy] = 2;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end;
		time = 0;
		while (true) {
			if (size() == 0)
				break;
			last = size();
			bfs();
			melt();
			time++;
		}
		System.out.println(time);
		System.out.println(last);
	}

}
