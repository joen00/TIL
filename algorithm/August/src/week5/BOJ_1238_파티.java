package week5;

import java.util.*;
import java.io.*;

public class BOJ_1238_파티 {

	static ArrayList<node>[] list;
	static int arr[];
	static int N, M, X;
	static int MAX = Integer.MIN_VALUE;

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

	static void dijst(int start, boolean check) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start, 0));
		int dist[] = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		while (!pq.isEmpty()) {
			node cur = pq.poll();
			if (check && cur.b == X)
				break;
			for (node i : list[cur.b]) {
				if (dist[i.b] > cur.w + i.w) {
					dist[i.b] = cur.w + i.w;
					pq.add(new node(i.b, dist[i.b]));
				}
			}
		}
		if (check)
			arr[start] = dist[X];
		else {
			for (int i = 1; i <= N; i++) {
				arr[i] = arr[i] + dist[i];
				MAX = Math.max(arr[i], MAX);
			}
		}
		// System.out.println(start + " : " + Arrays.toString(dist));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new node(b, w));
		} // input end;

		for (int i = 1; i <= N; i++) {
			if (i != X)
				dijst(i, true);
			// System.out.println(Arrays.toString(arr));
		}
		dijst(X, false);
		// System.out.println(Arrays.toString(arr));
		System.out.println(MAX);
	}

}
