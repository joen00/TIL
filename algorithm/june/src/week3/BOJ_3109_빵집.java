package week3;

import java.util.*;
import java.io.*;

public class BOJ_3109_빵집 {

	static int R, C, flag, result;
	static char map[][];
	static int direct[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	static void dfs(int x, int y) {

		if (y == C - 1) {
			map[x][y] = 'x';
			flag = 1;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int dx = direct[i][0] + x;
			int dy = direct[i][1] + y;
			if (flag == 1)
				continue;
			if (dx < 0 || dx >= R || dx < 0 || dy >= C)
				continue;
			if (map[dx][dy] == 'x')
				continue;
			map[dx][dy] = 'x';
			dfs(dx, dy);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		result = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // input end

		for (int i = 0; i < R; i++) {
			flag = 0;
			dfs(i, 0);
		}
		for (int i = 0; i < R; i++) {
			if (map[i][C - 1] == 'x')
				result++;
		}
		System.out.println(result);
	}

}
