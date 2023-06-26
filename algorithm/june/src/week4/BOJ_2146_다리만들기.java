package week4;

import java.io.*;
import java.util.*;

public class BOJ_2146_다리만들기 {

	static int N, MIN;
	static int map[][];
	static int map2[][];
	static List<node> list;
	static boolean visit[][];
	static int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int path[];

	static class node {
		int x, y, num;

		public node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	static void initSetting(int index, int x, int y) {
		Queue<node> q = new ArrayDeque<>();
		q.add(new node(x, y, 0));
		visit[x][y] = true;
		map2[x][y] = index;
		while (!q.isEmpty()) {
			node cur = q.poll();
			int cnt = 0;
			// 4방향중 하나라도 뻗어나갈 곳이 없다면 바다가 있다는 뜻
			for (int d = 0; d < 4; d++) {
				int dx = direct[d][0] + cur.x;
				int dy = direct[d][1] + cur.y;
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (map[dx][dy] == 0) {
					cnt++;
					continue;
				}
				if (visit[dx][dy])
					continue;
				q.add(new node(dx, dy, 0));
				visit[dx][dy] = true;
				map2[dx][dy] = index;
			}
			if (cnt > 0)
				list.add(new node(cur.x, cur.y, index));
		}

	}

	static void bfs(int startx, int starty, int num) {

		Queue<node> q = new ArrayDeque<>();
		visit = new boolean[N][N];
		q.add(new node(startx, starty, 0));
		visit[startx][starty] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				node cur = q.poll();
				if (MIN < cnt)
					return;
				if (map2[cur.x][cur.y] != num && map2[cur.x][cur.y] != 0) {
					MIN = Math.min(cnt - 1, MIN);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int dx = direct[d][0] + cur.x;
					int dy = direct[d][1] + cur.y;
					if (dx < 0 || dy < 0 || dx >= N || dy >= N)
						continue;
					if (map2[dx][dy] == num)
						continue;
					if (visit[dx][dy])
						continue;
					q.add(new node(dx, dy, 0));
					visit[dx][dy] = true;
				}
			}
			cnt++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map2 = new int[N][N];
		visit = new boolean[N][N];
		MIN = Integer.MAX_VALUE;
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		int index = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					initSetting(index, i, j);
					index++;
				}
			}
		} // 초기 세팅 완료

		for (int i = 0; i < list.size(); i++) {
			bfs(list.get(i).x, list.get(i).y, list.get(i).num);
		}

		System.out.println(MIN);
	}

}
