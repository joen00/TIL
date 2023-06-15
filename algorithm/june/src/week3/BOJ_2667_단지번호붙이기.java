package week3;

import java.util.*;
import java.io.*;

public class BOJ_2667_단지번호붙이기 {

	static int N;
	static int map[][];
	static List<Integer> list;
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean visit[][];
	static Queue<node> q;

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int bfs(int x, int y) {

		q = new ArrayDeque<>();
		visit[x][y] = true;
		q.add(new node(x, y));

		int cnt = 0;
		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (visit[dx][dy])
					continue;
				if (map[dx][dy] == 0)
					continue;
				q.add(new node(dx, dy));
				visit[dx][dy] = true;
			}
			cnt++;
		}
		return cnt;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		} // input end

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					list.add(bfs(i, j));
					result++;
				}
			}
		}

		Collections.sort(list);
		System.out.println(result);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
