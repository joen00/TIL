package week4;

import java.io.*;
import java.util.*;

public class BOJ_1466_지름길 {

	static int N, D;
	static ArrayList<node> arr[];
	static int dist[];

	static class node {
		int b, cost;

		public node(int b, int cost) {
			this.b = b;
			this.cost = cost;
		}
	}

	static void dfs(int start) {
		if (start > D)
			return;
		if (dist[start + 1] > dist[start] + 1) {
			dist[start + 1] = dist[start] + 1;
		}
		for (int i = 0; i < arr[start].size(); i++) {
			if (dist[start] + arr[start].get(i).cost < dist[arr[start].get(i).b]) {
				dist[arr[start].get(i).b] = dist[start] + arr[start].get(i).cost;
			}
		}
		dfs(start + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new ArrayList[10001];
		dist = new int[10001];
		for (int i = 0; i <10001; i++) {
			dist[i] = Integer.MAX_VALUE;
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[a].add(new node(b, cost));
		}
		dist[0] = 0;
		dfs(0);
		System.out.println(dist[D]);
	}

}
