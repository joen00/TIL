package week4;

import java.io.*;
import java.util.*;

public class BOJ_1600_말이되고픈원숭이 {

	static int K, W, H;
	static int map[][];
	static int direct[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int directh[][] = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
	static boolean visit[][][];

	static class node {
		int x, y, check, cnt;

		public node(int x, int y, int check, int cnt) {
			this.x = x;
			this.y = y;
			this.check = check;
			this.cnt = cnt;
		}
	}

	static int bfs() {

		Queue<node> q = new ArrayDeque<>();
		q.add(new node(0, 0, 0, 0));
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			// 그냥 갈때
			node cur = q.poll();
			if (cur.x == H - 1 && cur.y == W - 1)
				return cur.cnt;
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= H || dy >= W)
					continue;
				if (map[dx][dy] == 1)
					continue;
				if (visit[dx][dy][cur.check])
					continue;
				visit[dx][dy][cur.check] = true;
				q.add(new node(dx, dy, cur.check, cur.cnt + 1));
			}
			// 말이 될때
			if (cur.check < K) {
				for (int d = 0; d < 8; d++) {
					int dx = directh[d][0] + cur.x;
					int dy = directh[d][1] + cur.y;
					if (dx < 0 || dy < 0 || dx >= H || dy >= W)
						continue;
					if (map[dx][dy] == 1)
						continue;
					if (visit[dx][dy][cur.check + 1])
						continue;
					visit[dx][dy][cur.check + 1] = true;
					q.add(new node(dx, dy, cur.check + 1, cur.cnt + 1));
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // inputend
		System.out.println(bfs());

	}

}
