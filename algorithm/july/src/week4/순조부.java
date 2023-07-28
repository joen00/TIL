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

		// 순열
		// dfs1(0);

		// 조합
		// dfs2(0, 0);

		// 부분집합
		// dfs3(0);

		// 부분집합 코드만 다르고 순열이랑 조합은 start의 차이 빼고는 다 똑같다.
		
		// [코드 방식]
		// arr이라는 원본 배열에서 path가 내가 뽑고 싶은 것들이다. => 완성본
		// level 은 내가 몇개를 뽑는지
		// for문은 원본 배열의 길이만큼 돌려주면 된다.
		// 이것만 기억하면 된다!! => 재귀 돌릴때 트리 형태를 생각하면  level은 높이이고 for문은 가로이다. 

	}

}
