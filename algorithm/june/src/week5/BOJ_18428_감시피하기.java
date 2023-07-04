package week5;

import java.io.*;
import java.util.*;

public class BOJ_18428_감시피하기 {

	static int N, result;
	static char map[][];
	static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean visit[][];
	static List<node> teacher;
	static List<node> list;
	static int path[];

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int bfs(int path[]) {
		// 만약 학생을 안만나면 result = 1로 체크해주기
		visit = new boolean[N][N];
		for (int i = 0; i < 3; i++) {
			visit[list.get(path[i]).x][list.get(path[i]).y] = true;
		}
		int flag = 0;
		
		for (int i = 0; i < teacher.size(); i++) {
			// 여기에서 하나씩 돌리기
			for (int d = 0; d < 4; d++) {
				int s = 1;
				while (true) {
					int dx = (direct[d][0] * s) + teacher.get(i).x;
					int dy = (direct[d][1] * s) + teacher.get(i).y;
					if (dx < 0 || dy < 0 || dx >= N || dy >= N)
						break;
					if (visit[dx][dy])
						break;
					if (map[dx][dy] == 'T')
						break;
					if (map[dx][dy] == 'S') {
						flag = 1;
						break;
					}
					s++;
				}
				if (flag == 1)
					break;
			}
			if (flag == 1)
				break;
		}

		return flag;
	}

	static void dfs(int start, int level) {

		if (result == 1)
			return;
		if (level == 3) {
			if (bfs(path) == 0)
				result = 1;
			return;
		}

		for (int i = start; i < list.size(); i++) {
			path[level] = i;
			dfs(i + 1, level + 1);
			path[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new boolean[N][N];
		path = new int[3];
		list = new ArrayList<>();
		teacher = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] strArray = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = strArray[j].charAt(0);
				if (map[i][j] == 'T')
					teacher.add(new node(i, j));
				else if (map[i][j] == 'X')
					list.add(new node(i, j));
			}
		} // input end

		dfs(0, 0);
		if (result == 1)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
