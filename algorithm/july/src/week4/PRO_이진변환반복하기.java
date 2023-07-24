package week4;

import java.io.*;
import java.util.*;

public class PRO_이진변환반복하기 {

	static public int[] solution(String s) {


		int countZero = 0;
		String str = s;
		int count = 0;
		while (true) {
			String noZero = "";

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') {
					countZero++;
				} else
					noZero = noZero + "1";
			}

			// 그때의 길이
			int len = noZero.length();
			// 길이 이진 변환
			str = "";
			
			while (true) {
				if (len == 0)
					break;
				if (len % 2 == 1)
					str = str + "1";
				else
					str = str + "0";
				len = len / 2;
			}
			count++;

			if (str.equals("1"))
				break;
		}
		int[] answer = {count, countZero};
		return answer;
	}

	public static void main(String[] args) {
		String s = "1111111";
		solution(s);

	}

}
