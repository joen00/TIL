package week4;

import java.util.*;
import java.io.*;

public class BOJ_5972_택배배송 {

	static boolean visit[];
	static int N, M;
	static int dist[];
	static ArrayList<node>[] list;

	static class node implements Comparable<node> {
		int b, w;

		public node(int b, int w) {
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}

	static void dijst() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1, 0));
		dist[1] = 0;
		while (!pq.isEmpty()) {
			node cur = pq.poll();
			for (node i : list[cur.b]) {
				if (!visit[i.b] && dist[i.b] > cur.w + i.w) {
					dist[i.b] = cur.w + i.w;
					pq.add(new node(i.b, dist[i.b]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		visit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new node(b, w));
			list[b].add(new node(a, w));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijst();
		
//		dist[1] = 0;
//
//		for (int n = 0; n < N; n++) {
//			// 돌려야할 값 찾기 -> 가장 작은 값 찾기
//			int min = Integer.MAX_VALUE;
//			int minIndex = 0;
//			for (int i = 1; i <= N; i++) {
//				if (!visit[i] && dist[i] < min) {
//					min = dist[i];
//					minIndex = i;
//				}
//			}
//			visit[minIndex] = true;
//			// dist에 갱신해주기
//
//			for (node i : list[minIndex]) {
//				if (!visit[i.b] && dist[i.b] > min + i.w) {
//					dist[i.b] = min + i.w;
//				}
//			}
//			// 방문체크
//		}

		System.out.println(dist[N]);
	}

}
