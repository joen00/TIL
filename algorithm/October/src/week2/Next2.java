package week2;

import java.io.*;
import java.util.*;

public class Next2 {

	
	static class node implements Comparable<node>{
		String date, time, status, message;
		public node(String date, String time,String status,String message) {
			this.date = date;
			this.time = time;
			this.status = status;
			this.message = message;
		}
		
		@Override
		public int compareTo(node o) {
			String datesThis[] = this.date.split("-");
			String datesO[] = o.date.split("-");
			if (datesThis[2].equals(datesO[2])) { // 년도가 같다면
				if (datesThis[1].equals(datesO[1])) { // 월이 같다면
					if (datesThis[0].equals(datesO[0])) { // 일이 같다면
						String timeThis[] = this.time.split(":");
						String timeO[] = o.time.split(":");
						int time1 = (Integer.parseInt(timeThis[0]) * 60) + Integer.parseInt(timeThis[1]);
						int time2 = (Integer.parseInt(timeO[0]) * 60) + Integer.parseInt(timeO[1]);
						return time1 - time2;
					}
					int da1 = Integer.parseInt(datesThis[0]);
					int da2 = Integer.parseInt(datesO[0]);
					return da1 - da2;
				}
				int da1 = Integer.parseInt(datesThis[1]);
				int da2 = Integer.parseInt(datesO[1]);
				return da1 - da2;
			}
			int da1 = Integer.parseInt(datesThis[2]);
			int da2 = Integer.parseInt(datesO[2]);
			return da1 - da2;
			
		}
		
	}
	
	public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
		List<node> list = new ArrayList<>();
		for(int i=0;i<logs.size();i++) {
			if (logs.get(i).get(2).equals("ERROR") || logs.get(i).get(2).equals("CRITICAL")) {
				list.add(new node(logs.get(i).get(0), logs.get(i).get(1), logs.get(i).get(2), logs.get(i).get(3)));
			}
		}
		Collections.sort(list);
		List<List<String>> result = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			List<String> arr = new ArrayList<>();
			arr.add(list.get(i).date);
			arr.add(list.get(i).time);
			arr.add(list.get(i).status);
			arr.add(list.get(i).message);
			result.add(arr);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
