package week2;

import java.util.*;
import java.io.*;

public class BOJ_20207_달력 {

	static ArrayList<input> list;
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int map[][];
	static int result[][];
	static int N, answer, M;
	static boolean visit[][];

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class input implements Comparable<input> {

		int start, end, dur;

		public input(int start, int end, int dur) {
			this.start = start;
			this.end = end;
			this.dur = dur;
		}

		@Override
		public int compareTo(input o) {
			if (this.start == o.start)
				return o.dur - this.dur;
			return this.start - o.start;
		}

	}

	static void bfs(int startx, int starty) {
		Queue<node> q = new ArrayDeque<>();
		q.add(new node(startx, starty));
		visit[startx][starty] = true;
		int MAXx = startx;
		int MAXy = starty;
		while (!q.isEmpty()) {
			node cur = q.poll();
			MAXx = Math.max(MAXx, cur.x);
			MAXy = Math.max(MAXy, cur.y);
			for (int i = 0; i < 4; i++) {
				int dx = direct[i][0] + cur.x;
				int dy = direct[i][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N + 1 || dy >= M + 1)
					continue;
				if (map[dx][dy] != 1 || visit[dx][dy])
					continue;
				visit[dx][dy] = true;
				q.add(new node(dx, dy));
			}
		}
		
		for (int i = startx; i <= MAXx; i++) {
			for (int j = starty; j <= MAXy; j++) {
				result[i][j] = 1;
			}
		}
		
		return;
	}
	
	static void bfs1(int startx, int starty) {
		Queue<node> q = new ArrayDeque<>();
		q.add(new node(startx, starty));
		visit[startx][starty] = true;
		int MAXx = startx;
		int MAXy = starty;
		while (!q.isEmpty()) {
			node cur = q.poll();
			MAXx = Math.max(MAXx, cur.x);
			MAXy = Math.max(MAXy, cur.y);
			for (int i = 0; i < 4; i++) {
				int dx = direct[i][0] + cur.x;
				int dy = direct[i][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N + 1 || dy >= M + 1)
					continue;
				if (result[dx][dy] != 1 || visit[dx][dy])
					continue;
				visit[dx][dy] = true;
				q.add(new node(dx, dy));
			}
		}
		
		answer = answer + ((MAXx - startx + 1) * (MAXy - starty + 1));
		
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		M = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			M = Math.max(M, b);
			list.add(new input(a, b, b - a));
		}

		Collections.sort(list);
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		result = new int[N + 1][M + 1];
		for (int n = 0; n < N; n++) {
			// map에 넣기 시작
			for (int i = 0; i < 1000; i++) {
				int a = list.get(n).start;
				int b = list.get(n).end;
				int flag = 0;
				for (int j = a; j <= b; j++) {
					if (map[i][j] == 1) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					for (int j = a; j <= b; j++) {
						map[i][j] = 1;
					}
					break;
				}
			}
		} // map에 넣기

//		for (int i = 0; i < 4; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		for (int i = 0; i < M + 1; i++) {
			if (map[0][i] == 1 && !visit[0][i]) {
				bfs(0, i);
			}
		}
//		System.out.println("-------------------------");
//		for (int i = 0; i < 4; i++) {
//			System.out.println(Arrays.toString(result[i]));
//		}
		visit = new boolean[N + 1][M + 1];
		for (int i = 0; i < M + 1; i++) {
			if (result[0][i] == 1 && !visit[0][i]) {
				bfs1(0, i);
			}
		}

		System.out.println(answer);

	}

}
