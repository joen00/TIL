package week4;

import java.util.*;
import java.io.*;

public class BOJ_2251_물통 {

	static int A, B, C;
	static ArrayList<node> list;
	static Set<Integer> answer;

	static class node {
		int a, b, c;

		public node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}


	static boolean check(int a, int b, int c) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).a == a && list.get(i).b == b && list.get(i).c == c)
				return false;
		}

		return true;
	}

	static void dfs(int level, int a, int b, int c) {

		if (!check(a, b, c))
			return;

		// System.out.println(a + " " + b + " " + c);
		list.add(new node(a, b, c));
		answer.add(c);
		// System.out.println();
		for (int i = 0; i < 3; i++) {
			if (A != 0) {
				if (B >= A && a + b <= B) {
					dfs(level + 1, a - a, b + a, c);
				}
				if (B <= A && b == 0 && a - B >= 0) {
					dfs(level + 1, a - B, b + B, c);
				}
				if (C >= A && a + c <= C) {
					dfs(level + 1, a - a, b, a + c);
				}
				if (C <= A && c == 0) {
					if (a - C >= 0)
						dfs(level + 1, a - C, b, c + A);
					else if (c + a <= C)
						dfs(level + 1, a - a, b, c + a);
				}
			}
			if (B != 0) {
				if (A >= B && a + b <= A) {
					dfs(level + 1, a + c, b - b, c);
				}
				if (A <= B && a == 0 && b - A >= 0) {
					dfs(level + 1, a + A, b - A, c);
				}
				if (C >= B && b + c <= C) {
					dfs(level + 1, a, b - b, c + b);
				}
				if (C <= B && c == 0 ) {
					if ( b - C >= 0)
						dfs(level + 1, a, b - C, c + B);
					else if (c + b <= B)
						dfs(level + 1, a, b - b, c + b);
				}
			}
			if (C != 0) {
				// 줄 수 있는 두가지의 경우
				// 내가 가진 것을 모두 줄 수 있다
				if (A >= C && a + c <= A) {
					dfs(level + 1, a + c, b, c - c);
				}
				// 상대방이 꽉 차도록 만든다.
				if (A <= C && a == 0 && c - A >= 0) {
					dfs(level + 1, a + A, b, c - A);
				}
				if (B >= C && b + c <= B) {
					dfs(level + 1, a, b + c, c - c);
				}
				if (B <= C && b == 0) {
					if (c - B >= 0)
						dfs(level + 1, a, b + B, c - B);
					else if (b + c <= B)
						dfs(level + 1, a, b + c, c - c);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		answer = new HashSet<>();

		dfs(0, 0, 0, C);
		ArrayList<Integer> result = new ArrayList<>(answer);
		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) == 0)
				continue;
			System.out.print(result.get(i) + " ");
		}

	}

}
