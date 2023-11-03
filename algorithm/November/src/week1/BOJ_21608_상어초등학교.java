package week1;

import java.util.*;
import java.io.*;

public class BOJ_21608_상어초등학교 {

	static int N;
	static int map[][];
	static boolean visit[][];
	static HashMap<Integer, mapNode> hm;
	static PriorityQueue<node> pq;
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class mapNode {
		int a, b, c, d;

		public mapNode(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}

	static class node implements Comparable<node> {
		int x, y, like, empty;

		public node(int x, int y, int like, int empty) {
			this.x = x;
			this.y = y;
			this.like = like;
			this.empty = empty;
		}

		@Override
		public int compareTo(node o) {
			if (this.like == o.like) {
				if (this.empty == o.empty) {
					if (this.x == o.x) {
						return this.y - o.y;
					}
					return this.x - o.x;
				}
				return o.empty - this.empty;
			}
			return o.like - this.like;
		}

	}

	static void check(int x, int a, int b, int c, int d) {

		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				int like = 0;
				int empty = 0;
				for (int di = 0; di < 4; di++) {
					int dx = i + direct[di][0];
					int dy = j + direct[di][1];
					if (dx < 0 || dy < 0 || dx >= N || dy >= N)
						continue;
					if (map[dx][dy] == a || map[dx][dy] == b || map[dx][dy] == c || map[dx][dy] == d)
						like++;
					if (map[dx][dy] == 0)
						empty++;
				} // 체크하는 곳
				pq.add(new node(i, j, like, empty));
			}
		}
		node cur = pq.poll();
		map[cur.x][cur.y] = x;
		visit[cur.x][cur.y] = true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		hm = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			hm.put(x, new mapNode(a, b, c, d));
			check(x, a, b, c, d);
		}

		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = map[i][j];
				mapNode mn = hm.get(x);
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int dx = i + direct[d][0];
					int dy = j + direct[d][1];
					if (dx < 0 || dy < 0 || dx >= N || dy >= N)
						continue;
					if (map[dx][dy] == mn.a || map[dx][dy] == mn.b || map[dx][dy] == mn.c || map[dx][dy] == mn.d)
						cnt++;
				}
				if (cnt == 1)
					answer = answer + 1;
				else if (cnt == 2)
					answer = answer + 10;
				else if (cnt == 3)
					answer = answer + 100;
				else if (cnt == 4)
					answer = answer + 1000;
			}
		}
		System.out.println(answer);
	}

}
