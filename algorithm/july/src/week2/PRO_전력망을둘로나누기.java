package week2;

import java.io.*;
import java.util.*;

public class PRO_전력망을둘로나누기 {

	static List<Integer>[] list;

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int n, int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean visit[] = new boolean[n + 1];
		q.add(start);
		visit[start] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int index : list[cur]) {
				if (index == end)
					continue;
				if (visit[index])
					continue;
				q.add(index);
				visit[index] = true;
				cnt++;
			}
		}
		return cnt;
	}

	static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < wires.length; i++) {
			int x = wires[i][0];
			int y = wires[i][1];
			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 0; i < wires.length; i++) {
			int x = wires[i][0];
			int y = wires[i][1];
			int s = bfs(n, x, y);
			int e = bfs(n, y, x);
			answer = Math.min(answer, Math.abs(s - e));
		}

		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {

		int wires[][] = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		solution(9, wires);

	}

}
