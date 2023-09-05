package week1;

import java.util.*;
import java.io.*;

public class BOJ_15681_트리와쿼리 {

	static ArrayList<Integer>[] list;
	static int N, R, Q;
	static boolean visit[];
	static ArrayList<Integer> answer; 
	static int arr[];

	static int dfs(int level) {
		
		if (visit[level])
			return arr[level];
		visit[level] = true;
		
		for(int i : list[level]) {
			if (visit[i])
				continue;
			arr[level] = arr[level] + dfs(i);
		}
		return arr[level];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		arr = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		Arrays.fill(arr, 1);
		
		dfs(R);
		System.out.println(Arrays.toString(arr));
		answer = new ArrayList<>();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			System.out.println(arr[a]);
		} // input end
		
		

	}

}
