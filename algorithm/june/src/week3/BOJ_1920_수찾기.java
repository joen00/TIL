package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	static int N, M;
	static int arr[];

	static void bin(int search) {

		int start = 0;
		int end = N - 1;
		int result = 0;
		
		while (true) {
			int mid = (start + end) / 2;
			if (arr[mid] == search) {
				result = 1;
				break;
			} else if (arr[mid] > search) {
				end = mid - 1;
			} else if (arr[mid] < search) {
				start = mid + 1;
			}
			if (start > end)
				break;
		}
		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int search = Integer.parseInt(st.nextToken());
			bin(search);
		}

	}

}
