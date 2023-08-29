package week5;

import java.util.*;
import java.io.*;

public class BOJ_17182 {

	static int N, M;
	static int dist[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(dist[M][i], result);
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
		System.out.println(result);
	}

}
