package week2;

import java.util.Scanner;

public class BOJ_2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int result = 2;
		if (a == 1) {
			System.out.println(1);
			return;
		}
		int cnt = 1;
		while (true) {
			if (a < result)
				break;
			result = result + (6 * cnt);
			cnt++;
		}
		System.out.println(cnt);
	}

}
