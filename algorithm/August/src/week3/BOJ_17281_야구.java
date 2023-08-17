package week3;

import java.util.*;
import java.io.*;

public class BOJ_17281_야구 {

	static int path[];
	static int path1[];
	static boolean visit[];
	static int N, MAX;
	static int map[][];
	static int s;

	static int getScore() {

		int result = 0;
		int index = 0; // path 배열의 시작 위치
		
		
		for (int i = 0; i < N; i++) {
			int out = 0;
			Queue<Integer> q = new ArrayDeque<>();
			while (true) {
				if (out == 3) {
					break;	
				}
				if (index == 9)
					index = 0;
				// 초기 조건
				int score = map[i][path1[index]];
				if (score == 0) {
					out++;
					index++;
					continue;
				}
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int qscore = q.poll();
					qscore = qscore + score;
					if (qscore <= 3)
						q.add(qscore);
					else
						result++;
				}
				if (score <= 3)
					q.add(score);
				else
					result++;
				index++;

			} // while end\
			
		} // for end
		
		return result;
	}

	static void dfs(int level) {

		if (level == 8) {
			path1 = new int[9];
			int j = 0;
			for (int i = 0; i < 9; i++) {
				if (i == 3) {
					path1[i] = 0;
					continue;
				}
				path1[i] = path[j];
				j++;
			}
			
		
			MAX = Math.max(getScore(), MAX);
			
			if (MAX == 46) {
				System.out.println(Arrays.toString(path1));
				s++;
			}return;
		}

		for (int i = 0; i < 8; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			path[level] = i + 1;
			dfs(level + 1);
			path[level] = 0;
			visit[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][9];
		path = new int[8];
		visit = new boolean[8];
		MAX = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		dfs(0);

		System.out.println(MAX);
		System.out.println(s);
	}

}
