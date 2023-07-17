package week3;

import java.util.*;
import java.io.*;

public class BOJ_15686_치킨배달 {

	static int N, M, MIN;
	static int map[][];
	static List<node> home;
	static List<node> chicken;
	static int path[];

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void chickendDis() {

		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int m = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int dis = Math.abs(home.get(i).x - chicken.get(path[j]).x)
						+ Math.abs(home.get(i).y - chicken.get(path[j]).y);
				m = Math.min(dis, m);
			}

			sum = sum + m;
		}
		MIN = Math.min(sum, MIN);

	}

	static void dfs(int start, int level) {

		if (level == M) {
			chickendDis();
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			path[level] = i;
			dfs(i + 1, level + 1);
			path[level] = -1;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		path = new int[M];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new node(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new node(i, j));
				}
			}
		} // input 끝
		MIN = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(MIN);
	}

}
