package week4;

import java.util.*;
import java.io.*;

public class BOJ_1753_최단경로 {

	static int V, E, K;
	static List<node>[] list;
	static int dist[];
	static boolean visit[];

	static class node {
		int v, w;

		public node(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[V + 1];
		visit = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new node(v, w));
		} // input end

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		// 최단 거리 찾기
		for (int i = 1; i <= V; i++) {
			// 최단 거리의 노드 찾기
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int j = 1; j <= V; j++) {
				if (!visit[j] && dist[j] < min) {
					min = dist[j];
					index = j;
				}
			}
			visit[index] = true;
			
			for (node j : list[index]) {
				if (!visit[j.v] && dist[j.v] > dist[index] + j.w) {
					dist[j.v] = dist[index] + j.w;
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (i == K)
				System.out.println(0);
			else if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	}

}
