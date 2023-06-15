package week3;

import java.util.*;
import java.io.*;

public class BOJ_1987_알파벳 {

	static int R, C, MAX;
	static boolean visit[][];
	static char map[][];
	static int word[];
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void dfs(int level, int x, int y) {

		MAX = Math.max(level, MAX);
		
		for (int d = 0; d < 4; d++) {
			int dx = direct[d][0] + x;
			int dy = direct[d][1] + y;
			if (dx < 0 || dx >= R || dy < 0 || dy >= C)
				continue;
			if (visit[dx][dy])
				continue;
			if (word[map[dx][dy]] == 1)
				continue;
			visit[dx][dy] = true;
			word[map[dx][dy]] = 1;
			dfs(level + 1, dx, dy);
			visit[dx][dy] = false;
			word[map[dx][dy]] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visit = new boolean[R][C];
		map = new char[R][C];
		word = new int[200];
		MAX = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		} // input end
		word[map[0][0]] = 1;
		visit[0][0] = true;

		dfs(1, 0, 0);
		System.out.println(MAX);

	}

}
