package week4;

import java.io.*;
import java.util.*;

public class SWEA_1238_Contact {

	static List<Integer>[] list;
	static boolean visit[];
	static Queue<node> q;
	static int N, start;

	static class node {
		int x, cnt;

		public node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

	}

	static int bfs(int start) {

		q = new ArrayDeque<>();
		q.add(new node(start, 0));
		visit[start] = true;
		int cnt = 0;
		int MAX = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			MAX = 0;
			for (int s = 0; s < size; s++) {
				node cur = q.poll();
				MAX = Math.max(cur.x, MAX);
				for (int index : list[cur.x]) {
					if (visit[index])
						continue;
					q.add(new node(index, cur.cnt + 1));
					visit[index] = true;

				}
			}
		}
		return MAX;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			list = new ArrayList[101];
			visit = new boolean[101];
			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			} // input end

			System.out.println("#" + t + " " + bfs(start));
		}

	}

}
