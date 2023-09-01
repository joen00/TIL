package week5;

import java.util.*;
import java.io.*;

public class BOJ_3190_뱀 {

	static int map[][];
	static Queue<snakeNode> snake;
	static int direct[][] = { { 0, 1, 3, 1 }, { 1, 0, 0, 2 }, { 0, -1, 1, 3 }, { -1, 0, 2, 0 } };
	// 오른쪽 아래 왼쪽 위 -> 왼쪽 , 오른쪽[현재위치(x,y), 왼쪽, 오른쪽]
	static int N, K, L;
	static ArrayList<directNode> list;

	static class snakeNode {
		int x, y;

		public snakeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class directNode {
		int x;
		char c;

		public directNode(int x, char c) {
			this.x = x;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 1; // 사과 있는 위치
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			list.add(new directNode(x, c));
		} // input end;
		
		// 시작
		snake = new ArrayDeque<>();
		int t = 0; // 시간
		int listIndex = 0;
		int nowx = 0;
		int nowy = 0;
		int nowDirect = 0;
		snake.add(new snakeNode(0, 0));
		F: while (true) {
			t++;
			nowx = nowx + direct[nowDirect][0];
			nowy = nowy + direct[nowDirect][1];

			if (nowx < 0 || nowy < 0 || nowx >= N || nowy >= N)
				break; // 벽을 만날 때

			if (map[nowx][nowy] != 1) { // 사과 발견할때 뱀의 길이 늘려주기

				for (int s = 0; s < snake.size(); s++) {
					snakeNode cur = snake.poll();
					if (cur.x == nowx && cur.y == nowy) {
						break F;
					}
					snake.add(new snakeNode(cur.x, cur.y));
				} // 뱀을 만날때

				snake.add(new snakeNode(nowx, nowy));
				snakeNode o = snake.poll();
			} else {
				snake.add(new snakeNode(nowx, nowy));
				map[nowx][nowy] = 0;
			}

			if (listIndex != list.size() && t == list.get(listIndex).x) {
				if (list.get(listIndex).c == 'L')
					nowDirect = direct[nowDirect][2];
				if (list.get(listIndex).c == 'D')
					nowDirect = direct[nowDirect][3];
				listIndex++;
			}
		}

		System.out.println(t);

	}

}
