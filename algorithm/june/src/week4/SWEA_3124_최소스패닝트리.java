package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {

	static int V, E;
	static int arr[];
	static List<node> list;

	static class node implements Comparable<node> {
		int x, y, cnt;

		public node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(node o) {
			return this.cnt - o.cnt;
		}

	}

	static int findboss(int a) {
		if (arr[a] == 0)
			return a;
		return arr[a] = findboss(arr[a]);
	}

	static void setUnion(int a, int b) {
		int finda = findboss(a);
		int findb = findboss(b);
		if (finda == findb)
			return;
		arr[findb] = finda;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new int[V + 1];
			list = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new node(a, b, c));
			} // input end;
			long sum = 0;
			Collections.sort(list);
			for (int i = 0; i < E; i++) {
				if (findboss(list.get(i).x) != findboss(list.get(i).y)) {
					setUnion(list.get(i).x, list.get(i).y);
					sum = sum + list.get(i).cnt;
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}

}
