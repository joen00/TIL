package week2;

import java.io.*;
import java.util.*;

public class Next1 {

	public static int findMaximumGreatness(List<Integer> arr) {
		
		Collections.sort(arr);
		int index = 0;
		int start = 0;
		while (true) {
			if (start >= arr.size())
				break;
			int check = 0;
			for(int i=start;i<arr.size();i++) {
				if(arr.get(index) < arr.get(i)) {
					check = i;
					break;
				}
			}
			if (check == 0)
				break;
			start = check;
			index++;
			start++;
		}
		
		return index;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			arr.add(a);
		}
		System.out.println(findMaximumGreatness(arr));
		
	}

}
