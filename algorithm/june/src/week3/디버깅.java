package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 디버깅 {

	static int path[];

	private static void dfs(int level) {

		if (level == 2) {
			System.out.println(Arrays.toString(path));
			return;
		}

		for (int i = 0; i < 4; i++) {
			path[level] = i;
			dfs(level + 1);
			path[level] = 0;
		}

	}

	public static void main(String[] args) throws IOException {
		path = new int[2];
		dfs(0);

	}

}