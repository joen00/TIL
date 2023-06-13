package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {

	static int N, M, R;
	static int map[][];

	
	static void moveMap(int startx, int starty, int endx, int endy) {
		
		int temp = map[startx][starty];
		for(int i=0;i<endy-starty;i++) {
			map[startx][starty + i] = map[starty][starty + i + 1];
		}
		for(int i=0;i<endx-startx;i++) {
			map[startx + i][endy] = map[startx + i + 1][endy];
		}
		for(int i=endy;i>=starty + 1;i--) {
			map[endx][i] = map[endx][i - 1];
		}
		for(int i=endx;i>=startx + 1;i--) {
			map[i][starty] = map[i - 1][starty];
		}
		map[startx + 1][starty] = temp;
		
		//print();
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end
		
		for(int r =0; r<R;r++) {
			for(int i=0;i<(Math.min(N, M))/2;i++) {
				// System.out.println(i+ " " +  i + " " +  (N - i - 1) + " " + (M - i - 1));
				moveMap(i, i, N - i - 1, M - i - 1);
				//System.out.println("------------------------------");
			}
		}
		print();

	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
