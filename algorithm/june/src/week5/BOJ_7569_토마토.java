package week5;

import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {

	static int map[][][];
	static int N, M, H, result;
	static boolean visit[][][];
	static int direct[][] = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static List<node> list;

	static class node {
		int z, x, y;

		public node(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {

		Queue<node> q = new ArrayDeque<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(new node(list.get(i).z, list.get(i).x, list.get(i).y));
			visit[list.get(i).z][list.get(i).x][list.get(i).y] = true;
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				node cur = q.poll();
				for (int d = 0; d < 6; d++) {
					int dz = direct[d][0] + cur.z;
					int dx = direct[d][1] + cur.x;
					int dy = direct[d][2] + cur.y;
					if (dz < 0 || dx < 0 || dy < 0 || dz >= H || dx >= N || dy >= M)
						continue;
					if (visit[dz][dx][dy] || map[dz][dx][dy] == -1 || map[dz][dx][dy] == 1)
						continue;
					q.add(new node(dz, dx, dy));
					visit[dz][dx][dy] = true;
					result--;
				}
			}
			cnt++;
		}
		if (result == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		list = new ArrayList<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if (map[h][n][m] == 1)
						list.add(new node(h, n, m));
					else if (map[h][n][m] == 0)
						result++;
				}
			}
		} // input end
		bfs();

	}

}
