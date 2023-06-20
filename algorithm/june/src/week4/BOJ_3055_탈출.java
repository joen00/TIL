package week4;

import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {

	static int R, C, startx, starty, endx, endy;
	static char map[][];
	static boolean visit[][];
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<node> waterq;
	static Queue<node> q;

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {
		q = new ArrayDeque<>();
		q.add(new node(startx, starty));

		int cnt = 0;
		while (!q.isEmpty()) {
			// 먼저 물 부터
			int size = waterq.size();
			for (int s = 0; s < size; s++) {
				node cur = waterq.poll();
				for (int i = 0; i < 4; i++) {
					int dx = direct[i][0] + cur.x;
					int dy = direct[i][1] + cur.y;
					if (dx < 0 || dy < 0 || dx >= R || dy >= C)
						continue;
					if (map[dx][dy] == 'X' || map[dx][dy] == 'D' || map[dx][dy] == '*')
						continue;
					waterq.add(new node(dx, dy));
					map[dx][dy] = '*';
				}
			}
			// 가야함
			size = q.size();
			for (int s = 0; s < size; s++) {
				node cur = q.poll();
				if (cur.x == endx && cur.y == endy) {
					System.out.println(cnt);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int dx = direct[i][0] + cur.x;
					int dy = direct[i][1] + cur.y;
					if (dx < 0 || dy < 0 || dx >= R || dy >= C)
						continue;
					if (map[dx][dy] == 'X' || map[dx][dy] == '*' || map[dx][dy] == 'S')
						continue;
					q.add(new node(dx, dy));
					map[dx][dy] = 'S';
				}
			}
			cnt++;
		}
		System.out.println("KAKTUS");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		waterq = new ArrayDeque<>();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'D') {
					endx = i;
					endy = j;
				} else if (map[i][j] == 'S') {
					startx = i;
					starty = j;
				} else if (map[i][j] == '*') {
					waterq.add(new node(i, j));
				}
			}
		} // input end

		bfs();

	}

}
