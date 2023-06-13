package week3;

import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	static int N, sum, MIN;
	static int map[][];
	static int startarr[];
	static int linkarr[];
	static int path[];

	// 두개의 팀의 조합으로 계산
	static void dfs2(int start, int level, int arr[]) {

		if (level == 2) {
			sum = sum + map[path[0]][path[1]] + map[path[1]][path[0]];
			return;
		}

		for (int i = start; i < N / 2; i++) {
			path[level] = arr[i];
			dfs2(i + 1, level + 1, arr);
			path[level] = 0;

		}

	}

	// 두개의 팀으로 분리하는 것
	static void dfs(int start, int level) {

		if (level == N / 2) {
			// start에 대한 조합은 구함
			// link에 대한 조합

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(i);
			}
			for (int i = 0; i < N / 2; i++) {
				list.remove(list.indexOf(startarr[i]));
			}
			for (int i = 0; i < N / 2; i++) {
				linkarr[i] = list.get(i);
			}
			sum = 0;
			dfs2(0, 0, startarr);
			int startsum = sum;
			sum = 0;
			dfs2(0, 0, linkarr);
			int linksum = sum;
			MIN = Math.min(MIN, Math.abs(startsum - linksum));
			return;
		}

		for (int i = start; i < N; i++) {
			startarr[level] = i;
			dfs(i + 1, level + 1);
			startarr[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		startarr = new int[N / 2];
		linkarr = new int[N / 2];
		sum = 0;
		path = new int[2];
		MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		dfs(0, 0);

		System.out.println(MIN);
	}

}
