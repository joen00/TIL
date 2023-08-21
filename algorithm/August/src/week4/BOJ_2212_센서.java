package week4;

import java.util.*;
import java.io.*;

public class BOJ_2212_센서 {

	static int N, M;
	static int arr[];
	static Integer minus[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // input end

		Arrays.sort(arr);
		minus = new Integer[N - 1];
		for (int j = 0; j < N - 1; j++) {
			minus[j] = arr[j + 1] - arr[j];
		}
		
		Arrays.sort(minus, Collections.reverseOrder());
		int sum = 0;
		// System.out.println(Arrays.toString(minus));
		for (int i = M - 1; i < N - 1; i++) {
			sum = sum + minus[i];
		}
		System.out.println(sum);
	}

}
