package week2;

import java.util.*;
import java.io.*;

public class BOJ_2660_회장뽑기 {

	static int N;
	static ArrayList<Integer> list[];
	static boolean visit[];
	static int arr[];

	static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visit = new boolean[N + 1];
		visit[start] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size;s++) {
				int cur = q.poll();
				for(int i : list[cur]) {
					if (visit[i])
						continue;
					visit[i] = true;
					q.add(i);
				}
			}
			cnt++;
		}
		
		return cnt - 1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		
		arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			list[a].add(b);
			list[b].add(a);
		} // input end
		
		int MIN = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1; i<=N;i++) {
			arr[i] = bfs(i);
			// System.out.println(arr[i]);
			if (MIN > arr[i]) {
				cnt = 1;
				MIN = arr[i];
			}else if(MIN == arr[i])
				cnt++;
		}
		System.out.println(MIN + " " + cnt);
		for(int i = 1; i<=N;i++) {
			if (arr[i] == MIN)
				System.out.print(i + " ");
		}
		
	}

}
