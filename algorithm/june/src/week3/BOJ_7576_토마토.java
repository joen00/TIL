package week3;

import java.util.*;
import java.io.*;

public class BOJ_7576_토마토 {

	static int N, M, result;
	static List<node> Ripetomato;
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int map[][];
	static Queue<node> q;

	static class node {
		int x, y, cnt;

		public node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static void bfs() {

		q = new ArrayDeque<>();
		for (int i = 0; i < Ripetomato.size(); i++) {
			q.add(new node(Ripetomato.get(i).x, Ripetomato.get(i).y, 0));
		}


		while (!q.isEmpty()) {
			for (int s = 0; s < q.size(); s++) {
				node cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int dx = direct[d][0] + cur.x;
					int dy = direct[d][1] + cur.y;
					if (dx < 0 || dy < 0 || dx >= N || dy >= M)
						continue;
					if (map[dx][dy] == 1 || map[dx][dy] == -1)
						continue;
					map[dx][dy] = 1;
					// System.out.println(dx + " " + dy + " : " + cur.cnt);
					q.add(new node(dx, dy, cur.cnt + 1));
				}
				result = Math.max(cur.cnt, result);
			}
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Ripetomato = new ArrayList<>();
		result = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					Ripetomato.add(new node(i, j, 0));
			}
		} // input end

		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					result = -1;
			}
		}
		
		System.out.println(result);
		
	}

}
