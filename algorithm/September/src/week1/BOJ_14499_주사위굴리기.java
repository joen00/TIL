package week1;

import java.io.*;
import java.util.*;

public class BOJ_14499_주사위굴리기 {

	static int dice[][] = new int[4][3];
	static int N, M, x, y, K;
	static int map[][];
	static int direct[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static void moveEast() {
		int tmp = dice[1][0];
		dice[1][0] = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = tmp;
	}

	static void moveWest() {
		int tmp = dice[1][2];
		dice[1][2] = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = tmp;
	}

	static void moveSouth() {
		int tmp = dice[0][1];
		dice[0][1] = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = tmp;
	}

	static void moveNorth() {
		int tmp = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()); // input end

		for (int t = 0; t < K; t++) {
			int k = Integer.parseInt(st.nextToken());
			int dx = direct[k - 1][0] + x;
			int dy = direct[k - 1][1] + y;
			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			if (k == 1) {
				moveEast();
			} else if (k == 2) {
				moveWest();
			} else if (k == 3) {
				moveNorth();
			} else if (k == 4) {
				moveSouth();
			}
			if (map[dx][dy] == 0)
				map[dx][dy] = dice[1][1];
			else {
				dice[1][1] = map[dx][dy];
				map[dx][dy] = 0;
			}
			x = dx;
			y = dy;
// 			System.out.println(dice[3][1]);
		}

		

	}

}
