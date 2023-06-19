package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {

	static int N, K;
	static boolean visit[];

	static void bfs() {

		Queue<Integer> q = new ArrayDeque<>();
		visit[N] = true;
		q.add(N);

		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				if (cur == K) {
					System.out.println(cnt);
					return;
				}
				for (int i = 0; i < 3; i++) {
					if (i == 0 && cur <= 99999 && !visit[cur + 1]) {
						q.add(cur + 1);
						visit[cur + 1] = true;
					} else if (i == 1 && cur - 1 >= 0 && !visit[cur - 1]) {
						q.add(cur - 1);
						visit[cur - 1] = true;
					} else if (i == 2 && cur <= 50000 && !visit[cur * 2]) {
						q.add(cur * 2);
						visit[cur * 2] = true;
					}
				}
			}
			cnt++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[200000];
		bfs();

	}

}
