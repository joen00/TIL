package week4;

import java.io.*;
import java.util.*;

public class BOJ_10026_적록색약 {

	static int N;
	static boolean visitrgb[][];
	static boolean visitrb[][];
	static char maprgb[][];
	static char maprb[][];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfsrgb(int x, int y, char start) {

		Queue<node> q = new ArrayDeque();
		visitrgb[x][y] = true;
		q.add(new node(x, y));

		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (visitrgb[dx][dy])
					continue;
				if (maprgb[dx][dy] != start)
					continue;
				visitrgb[dx][dy] = true;
				q.add(new node(dx, dy));
			}
		}

	}

	static void bfsrb(int x, int y, char start) {

		Queue<node> q = new ArrayDeque();
		visitrb[x][y] = true;
		q.add(new node(x, y));

		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (visitrb[dx][dy])
					continue;
				if (maprb[dx][dy] != start)
					continue;
				visitrb[dx][dy] = true;
				q.add(new node(dx, dy));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		maprgb = new char[N][N];
		maprb = new char[N][N];
		visitrgb = new boolean[N][N];
		visitrb = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				maprgb[i][j] = s.charAt(j);
				if (maprgb[i][j] == 'G')
					maprb[i][j] = 'R';
				else
					maprb[i][j] = maprgb[i][j];
			}
		} // input end

		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitrgb[i][j]) {
					ans1++;
					bfsrgb(i, j, maprgb[i][j]);
				}
				if (!visitrb[i][j]) {
					ans2++;
					bfsrb(i, j, maprb[i][j]);
				}
			}
		}
		System.out.println(ans1 + " " + ans2);
	}

}
