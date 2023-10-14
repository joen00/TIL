package week2;


import java.util.*;
import java.io.*;

public class 골프1 {

	static int arr[];
	
	
	static int solution(int[] books, int[] target) {
		int answer = 0;
			
		for(int i=0;i<target.length;i++) {
			int targetNum = target[i];
			int arr[]= new int[books.length];
			for(int j=0;j<arr.length;j++) {
				arr[j] = books[j];
			}
			int index = 1;
			arr[0] = targetNum;
			boolean stop = false;
			for(int j=0;j<books.length;j++) {
				if (targetNum == books[j])
					stop = true;
				else {
					arr[index] = books[j];
					index++;
				}
				if (!stop)
					answer++;
			}
			
			for(int j=0;j<arr.length;j++) {
				books[j] = arr[j];
			}
			// System.out.println(Arrays.toString(books));
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		int books[] = {1, 2, 3, 4};
		int target[] =  {4, 4, 3, 2, 1};
		System.out.println(solution(books, target));

	}

}
