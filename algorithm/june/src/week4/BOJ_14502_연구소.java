package week4;

import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {

	static int N, M, MAX, originSum;
	static int map[][];
	static boolean visit[][];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<node> virus;
	static List<node> wall;
	static int path[];

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {

		Queue<node> q = new ArrayDeque<>();
		visit = new boolean[N][M];
		for (int i = 0; i < virus.size(); i++) {
			q.add(new node(virus.get(i).x, virus.get(i).y));
			visit[virus.get(i).x][virus.get(i).y] = true;
		} // 초기 세팅
		int sum = 0;
		while (!q.isEmpty()) {
			node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (map[dx][dy] == 1 || visit[dx][dy])
					continue;
				if (wall.get(path[0]).x == dx && wall.get(path[0]).y == dy)
					continue;
				if (wall.get(path[1]).x == dx && wall.get(path[1]).y == dy)
					continue;
				if (wall.get(path[2]).x == dx && wall.get(path[2]).y == dy)
					continue;
				visit[dx][dy] = true;
				q.add(new node(dx, dy));
			}
			sum++;
		}

		MAX = Math.max((originSum - sum - 3 + virus.size()), MAX);
	}

	static void dfs(int start, int level) {

		if (level == 3) {
			bfs();
			return;
		}

		for (int i = start; i < wall.size(); i++) {
			path[level] = i;
			dfs(i + 1, level + 1);
			path[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<>();
		wall = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new node(i, j));
				else if (map[i][j] == 0) {
					originSum++;
					wall.add(new node(i, j));
				}
			}
		} // input end;
		MAX = 0;
		path = new int[3];
		dfs(0, 0);
		System.out.println(MAX);

	}

}
