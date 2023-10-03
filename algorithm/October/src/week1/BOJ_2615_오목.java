package week1;

import java.io.*;
import java.util.*;

public class BOJ_2615_오목 {

	static int map[][];
	static int direct1[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 }, {-1, 1} };
	static int direct2[][] = { { 0, -1 }, { -1, 0 }, { -1, -1 }, {1, -1} };
	static int result, x, y;
	static ArrayList<node> white;
	static ArrayList<node> black;

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean isCheck(int startx, int starty, int color) {

		int flag = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			int x = startx;
			int y = starty;
			while (true) {
				int dx = direct1[i][0] + x;
				int dy = direct1[i][1] + y;
				if (dx < 0 || dy < 0 || dx >= 19 || dy >= 19)
					break;
				if (map[dx][dy] != color)
					break;
				x = dx;
				y = dy;
				cnt++;
			}
			x = startx;
			y = starty;
			int cnt1 =0;
			while (true) {
				int dx = direct2[i][0] + x;
				int dy = direct2[i][1] + y;
				if (dx < 0 || dy < 0 || dx >= 19 || dy >= 19)
					break;
				if (map[dx][dy] != color)
					break;
				x = dx;
				y = dy;
				cnt1++;
			}
			if (cnt == 4 && cnt1 == 0) {
				flag = 1;
			}
			// System.out.println(cnt + " " + cnt1);
		}
		
		if (flag == 1)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		white = new ArrayList<>();
		black = new ArrayList<>();
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					black.add(new node(i, j));
				else if (map[i][j] == 2)
					white.add(new node(i, j));
			}
		} // input end

		for (int i = 0; i < black.size(); i++) {
			if (isCheck(black.get(i).x, black.get(i).y, 1)) {
				result = 1;
				x = black.get(i).x + 1;
				y = black.get(i).y + 1;
				break;
			}
		}
		
		if (result != 1) {
			for (int i = 0; i < white.size(); i++) {
				if (isCheck(white.get(i).x, white.get(i).y, 2)) {
					result = 2;
					x = white.get(i).x + 1;
					y = white.get(i).y + 1;
					break;
				}
			}
		}
		if (result == 0)
			System.out.println(result);
		else {
			System.out.println(result);
			System.out.println(x + " " + y);
		}

	}

}
