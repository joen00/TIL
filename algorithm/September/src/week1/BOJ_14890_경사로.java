package week1;

import java.util.*;
import java.io.*;

public class BOJ_14890_경사로 {

	static int N, L;
	static int map[][];

	static boolean check(int start) {

		boolean visit[] = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			int a = map[start][i];
			int b = map[start][i + 1];
			if (Math.abs(a - b) >= 2)
				return false;
			if (Math.abs(a - b) == 1) {
				// L 만큼 돌리기
				for (int d = 0; d < L; d++) {
					if (a - b == 1) {
						if (i + 1 + d < 0 || i + 1 + d >= N || visit[i + 1 + d])
							return false;
						int c = map[start][i + 1 + d];
						if (c != b)
							return false;
						visit[i + 1 + d] = true;
					} else if (a - b == -1) {
						if (i - d < 0 || i - d >= N || visit[i - d])
							return false;
						int c = map[start][i - d];
						if (c != a)
							return false;
						visit[i - d] = true;
					}
				}
			}
		}
		//System.out.println(start + " " + 1);
		return true;

	}

	static boolean check1(int start) {

		boolean visit[] = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			int a = map[i][start];
			int b = map[i + 1][start];
			if (Math.abs(a - b) >= 2)
				return false;
			if (Math.abs(a - b) == 1) {
				// L 만큼 돌리기
				for (int d = 0; d < L; d++) {
					if (a - b == 1) {
						if (i + 1 + d < 0 || i + 1 + d >= N || visit[i + 1 + d])
							return false;
						int c = map[i + 1 + d][start];
						if (c != b)
							return false;
						visit[i + 1 + d] = true;
					} else if (a - b == -1) {
						if (i - d < 0 || i - d >= N || visit[i - d])
							return false;
						int c = map[i - d][start];
						if (c != a)
							return false;
						visit[i - d] = true;
					}
				}
			}
		}
		//System.out.println(start + " " + 2);
		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (check(i))
				cnt++;
		}
		for (int i = 0; i < N; i++) {
			if (check1(i))
				cnt++;
		}
		System.out.println(cnt);
	}

}
