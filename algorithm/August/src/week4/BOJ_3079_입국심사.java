package week4;

import java.util.*;
import java.io.*;

public class BOJ_3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long right = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(arr[i], right);
		}
		right = right * M;
		long left = 1;
		long result = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum = sum + (mid / arr[i]);
			}
			if (sum < M)
				left = mid + 1;
			else if (sum >= M) {
				right = mid - 1;
				result = mid;
			}
			
		}

		System.out.println(result);

	}

}
