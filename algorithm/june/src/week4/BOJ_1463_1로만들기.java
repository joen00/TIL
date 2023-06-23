package week4;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N + 3];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i <= N; i++) {
			int sum1 = Integer.MAX_VALUE;
			int sum2 = Integer.MAX_VALUE;
			int sum3 = Integer.MAX_VALUE;
			if (i % 3 == 0)
				sum1 = arr[i / 3];
			if (i % 2 == 0)
				sum2 = arr[i / 2];
			if (i > 1)
				sum3 = arr[i - 1];
			arr[i] = Math.min(sum1, Math.min(sum2, sum3)) + 1;
		}
		System.out.println(arr[N]);

	}

}
