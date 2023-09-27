package week4;

import java.util.*;
import java.io.*;

public class BOJ_14503_로봇청소기 {

	static int N, M, nowd, nowx, nowy;
	static int direct[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int backdirect[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int map[][];

	// 현재 방향에서 while 돌려서 갈곳 있는지 체크해줌
	// 90도로 회전해서 갈 수 있는 곳이면
	// 갈수 있는 방향 리턴 아니면 -1 리턴
	static int isCheck() {

		int cnt = 0;
		int checkd = nowd;
		while (true) {
			if (cnt == 4)
				break;
			// 방향 90도 반시계로 돌려봄
			checkd++;
			if (checkd == 4)
				checkd = 0;
			int dx = nowx + direct[checkd][0];
			int dy = nowy + direct[checkd][1];
			cnt++;

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			else if (map[dx][dy] == 0) {
				return checkd;
			}
		}
		return -1;
	}

	static void print() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nowx = Integer.parseInt(st.nextToken());
		nowy = Integer.parseInt(st.nextToken());
		nowd = Math.abs(Integer.parseInt(st.nextToken()) - 4);
		if (nowd == 4)
			nowd = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		map[nowx][nowy] = 2;
		int result = 1;
		
		while (true) {
			int check = isCheck();

			if (check == -1) { // 갈수 없는 곳
				int dx = nowx + backdirect[nowd][0];
				int dy = nowy + backdirect[nowd][1];
				if (dx < 0 || dy < 0 || dx >= N || dy >= M || map[dx][dy] == 1)
					break;
				nowx = dx;
				nowy = dy;
				
			} else { // 갈수 있는 곳
				nowd = check;
				nowx = nowx + direct[check][0];
				nowy = nowy + direct[check][1];
				result++;
				map[nowx][nowy] = 2;
			}
		}

	
		System.out.println(result);
	}

}
