package week4;

import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기 {

	static int K, N, M, MIN;
	static int path[];
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int map[][], mapCopy[][];

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}

		return copy;
	}

	// 벽돌 제거하기
	static void bfs(int pathIndex) {

		Queue<node> q = new ArrayDeque<>();
		boolean visit[][] = new boolean[N][M];
		// 처음 시작 위치
		for (int i = 0; i < N; i++) {
			if (mapCopy[i][path[pathIndex]] != 0) {
				q.add(new node(i, path[pathIndex]));
				break;
			}
		}
		// 가면서 벽돌깨기
		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < mapCopy[cur.x][cur.y]; i++) {
					int dx = direct[d][0] * i + cur.x;
					int dy = direct[d][1] * i + cur.y;
					if (dx < 0 || dy < 0 || dx >= N || dy >= M)
						continue;
					if (visit[dx][dy])
						continue;
					q.add(new node(dx, dy));
				}
			}
			mapCopy[cur.x][cur.y] = 0;
			visit[cur.x][cur.y] = true;
		}

		// 중력 제거
		int newMap[][] = new int[N][M];
		for (int i = 0; i < M; i++) {
			int start = N - 1;
			for (int j = N - 1; j >= 0; j--) {
				if (mapCopy[j][i] != 0) {
					newMap[start][i] = mapCopy[j][i];
					start--;
				}
			}
		}
		mapCopy = deepcopy(newMap);
		// 체크
//		if (path[0] == 3 && path[1] == 2 && path[2] == 1 && path[3] == 1) {
//			print(mapCopy);
//			System.out.println("------------------------------------");
//		}

	}

	static void dfs(int level) {

		if (level == K) {
			// System.out.println(Arrays.toString(path));
			mapCopy = deepcopy(map);
			for (int i = 0; i < K; i++) {
				bfs(i);
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapCopy[i][j] != 0)
						sum++;
				}
			}
			MIN = Math.min(sum, MIN);
			return;
		}

		for (int i = 0; i < M; i++) {
			path[level] = i;
			dfs(level + 1);
			path[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			path = new int[K];
			MIN = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input end

			dfs(0);
			System.out.println("#" + t + " " + MIN);
		}

	}

	static void print(int arr[][]) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
