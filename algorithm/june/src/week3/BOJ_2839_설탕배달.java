package week3;

import java.util.*;
import java.io.*;

public class BOJ_2839_설탕배달 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 3];
		for (int i = 0; i <= 4; i++) {
			arr[i] = -1;
		}
		arr[3] = 1;
		arr[5] = 1;
		for (int i = 6; i <= N; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			if (arr[i - 3] != -1)
				a = arr[i - 3] + 1;
			if (arr[i - 5] != -1)
				b = arr[i - 5] + 1;
			if (a == Integer.MAX_VALUE && b == Integer.MAX_VALUE)
				arr[i] = -1;
			else
				arr[i] = Math.min(a, b);
		}
		System.out.println(arr[N]);
	}

}
