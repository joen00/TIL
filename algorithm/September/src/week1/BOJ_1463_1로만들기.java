package week1;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기 {

	static boolean visit[];

	static int bfs(int N) {
		visit = new boolean[N];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (cur == 1)
					return cnt;
				if (cur <= 1)
					continue;
				if (cur % 3 == 0 && !visit[cur / 3]) {
					q.add(cur / 3);
					visit[cur / 3] = true;
				}
				if (cur % 2 == 0 && !visit[cur / 2]) {
					q.add(cur / 2);
					visit[cur / 2] = true;
				}
				if (!visit[cur - 1]) {
					q.add(cur - 1);
					visit[cur - 1] = true;
				}
			}
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(bfs(N));
	}

}
