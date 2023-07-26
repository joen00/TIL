package week4;

import java.io.*;
import java.util.*;

public class BOJ_14719_빗물 {

	static int H, W;
	static int arr[];
	static int MAXIndex, MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > MAX) {
				MAX = arr[i];
				MAXIndex = i;
			}
		} // input end

		int sum = 0;
		int left = arr[0];
		for (int i = 0; i < MAXIndex; i++) {
			if (left > arr[i]) {
				sum = sum + (left - arr[i]);
			} else {
				left = arr[i];
			}
		}
		
		int right = arr[W - 1];
		for (int i = W - 1; i >= MAXIndex; i--) {
			if (right > arr[i]) {
				sum = sum + (right - arr[i]);
			} else {
				right = arr[i];
			}
		}
		System.out.println(sum);
		

	}

}
