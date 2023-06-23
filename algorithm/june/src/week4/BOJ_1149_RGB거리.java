package week4;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + Integer.parseInt(st.nextToken());
			arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + Integer.parseInt(st.nextToken());
			arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + Integer.parseInt(st.nextToken());
		}
		System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));
	}

}
