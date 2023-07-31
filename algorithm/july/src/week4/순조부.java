package week4;

import java.util.*;
import java.io.*;

public class 순조부 {

	static int arr[] = { 1, 2, 3, 4 };
	static int path[];
	static boolean[] select = new boolean[arr.length];

	// 순열
	static void dfs1(int level) {

		if (level == 3) {
			System.out.println(Arrays.toString(path));
			return;
		}

		for (int i = 0; i < 4; i++) {
			path[level] = arr[i];
			dfs1(level + 1);
			path[level] = 0;
		}

	}

	// 조합
	static void dfs2(int start, int level) {

		if (level == 3) {
			System.out.println(Arrays.toString(path));
			return;
		}

		for (int i = start; i < 4; i++) {
			path[level] = arr[i];
			dfs2(i + 1, level + 1);
			path[level] = 0;
		}

	}

	// 부분 집합
	static void dfs3(int level) {

		if (level == arr.length) {
			System.out.print("지금 만들어진 부분집합 : { ");
			for (int i = 0; i < arr.length; i++) {
				if (select[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println("}");
			return;
		}
		select[level] = true;
		dfs3(level + 1);
		select[level] = false;
		dfs3(level + 1);

	}

	public static void main(String[] args) {

		path = new int[3];


	}

}
