package week4;

import java.io.*;
import java.util.*;

public class BOJ_1922_네트워크연결 {

	static int N, M;
	static int arr[];
	static List<node> list;

	static class node implements Comparable<node> {
		int x, y, w;

		public node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w - o.w;
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
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new node(x, y, w));
		}
		Collections.sort(list);
		int sum = 0;
		for (int i = 0; i < M; i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			int w = list.get(i).w;
			if (findboss(x) != findboss(y)) {
				setUnion(x, y);
				sum = sum + w;
			}
		}
		System.out.println(sum);
	}

}
