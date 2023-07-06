package week5;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {

	static int N, MIN;
	static List<Integer>[] list;
	static int population[];
	static boolean select[];
	static List<Integer> one, two;

	static boolean bfs(List<Integer> arr) {

		boolean visit[] = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(arr.get(0));
		visit[arr.get(0)] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int index : list[cur]) {
				if (visit[index])
					continue;
				if (!arr.contains(index))
					continue;
				q.add(index);
				visit[index] = true;
			}
			cnt++;
		}
		if (arr.size() == cnt)
			return true;
		return false;

	}

	static void dfs(int idx) {

		if (idx == N + 1) {
			// System.out.println(Arrays.toString(select));
			one = new ArrayList<>();
			two = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (select[i])
					one.add(i); // true;
				else
					two.add(i);
			}
			if (one.size() == 0 || two.size() == 0)
				return;
			// 두개를 동시에 bfs를 돌려서 비교
			if (bfs(one) && bfs(two)) {
				// 비교
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 1; i <= N; i++) {
					if (select[i])
						sum1 = sum1 + population[i];
					else
						sum2 = sum2 + population[i];
				}

				MIN = Math.min(MIN, Math.abs(sum1 - sum2));
			}

			return;
		}
		select[idx] = true;
		dfs(idx + 1);
		select[idx] = false;
		dfs(idx + 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		population = new int[N + 1];
		select = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		} // end
		MIN = Integer.MAX_VALUE;
		dfs(1);
		if (MIN == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(MIN);
	}

}
