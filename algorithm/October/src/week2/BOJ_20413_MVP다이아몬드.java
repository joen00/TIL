package week2;

import java.io.*;
import java.util.*;

public class BOJ_20413_MVP다이아몬드 {

	static int N;
	static int arr[];
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		str = br.readLine();
		int result = 0;

		char a = str.charAt(0);
		if (a == 'B')
			result = result + arr[0];
		else if (a == 'S')
			result = result + arr[1];
		else if (a == 'G')
			result = result + arr[2];
		else if (a == 'P')
			result = result + arr[3];
		else if (a == 'D')
			result = result + arr[3] + 1;
		int check = result;

		for (int i = 1; i < str.length(); i++) {
			a = str.charAt(i);
			if (a == 'B') {
				result = result + (arr[0] - check);
				check = arr[0] - check;
			} else if (a == 'S') {
				result = result + (arr[1] - check);
				check = arr[1] - check;
			} else if (a == 'G') {
				result = result + (arr[2] - check);
				check = arr[2] - check;
			} else if (a == 'P') {
				result = result + (arr[3] - check);
				check = arr[3] - check;
			} else if (a == 'D') {
				result = result + (arr[3] + 1);
				check = arr[3] + 1;
			}
		}
		System.out.println(result);
		
		String s = "asdf/asdfa/asdf";
		String split[] = s.split("/");
		System.out.println(Arrays.toString(split));
		
	}

}
