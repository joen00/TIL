package week4;

import java.io.*;
import java.util.*;

public class BOJ_14891_톱니바퀴 {

	static int check[];
	static int arr[][];

	static void rotationCheck(int start, int clock) {

		int cnt = clock;
		for (int i = start - 1; i >= 0; i--) {
			if (arr[i + 1][6] != arr[i][2]) {
				cnt = cnt * -1;
				check[i] = cnt;
			} else
				break;
		}

		cnt = clock;

		for (int i = start + 1; i < 4; i++) {
			if (arr[i][6] != arr[i - 1][2]) {
				cnt = cnt * -1;
				check[i] = cnt;
			} else
				break;
		}

	}

	static void rotationRight(int index) {

		int a = arr[index][7];
		for (int i = 7; i >= 1; i--) {
			arr[index][i] = arr[index][i - 1];
		}
		arr[index][0] = a;

	}

	static void rotationLeft(int index) {

		int a = arr[index][0];
		for (int i = 0; i <= 6; i++) {
			arr[index][i] = arr[index][i + 1];
		}
		arr[index][7] = a;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			check = new int[4];
			check[a] = b;
			// 톱니바퀴 체크
			rotationCheck(a, b);
			// 톱니바퀴 돌리기
			for (int i = 0; i < 4; i++) {
				if (check[i] == 1)
					rotationRight(i);
				else if (check[i] == -1)
					rotationLeft(i);
			}

		}

		int result = 0;
		if (arr[0][0] == 1)
			result = result + 1;
		if (arr[1][0] == 1)
			result = result + 2;
		if (arr[2][0] == 1)
			result = result + 4;
		if (arr[3][0] == 1)
			result = result + 8;
		System.out.println(result);
	}

}
