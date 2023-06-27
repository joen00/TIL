package week5;

import java.io.*;
import java.util.*;

public class BOJ_2458_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[N + 1][N + 1];
		int arr[] = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (map[j][i] && map[i][k])
						map[j][k] = true;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] || map[j][i])
					arr[i]++;
			}
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] == N - 1)
				result++;
		}
		System.out.println(result);

	}

}
