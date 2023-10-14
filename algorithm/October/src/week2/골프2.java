package week2;

import java.util.*;
import java.io.*;

public class 골프2 {

	static String name[];
	static ArrayList<String> character[];
	static HashMap<String, Integer> map;
	static ArrayList<node> top;
	static int noPurchased[];

	static class node implements Comparable<node> {
		String c;
		int cnt;

		public node(String c, int cnt) {
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(node o) {
			if (o.cnt == this.cnt)
				return this.c.compareTo(o.c);
			return o.cnt - this.cnt;
		}

	}

	static String solution(String[] products, String[] purchased) {
		String answer = "";
		name = new String[products.length];
		character = new ArrayList[products.length];
		for (int i = 0; i < products.length; i++) {
			character[i] = new ArrayList<>();
		}
		map = new HashMap<>();
		top = new ArrayList<>();
		noPurchased = new int[products.length - purchased.length];
		for (int i = 0; i < products.length; i++) {
			String splits[] = products[i].split(" ");
			name[i] = splits[0];
			for (int j = 1; j < splits.length; j++) {
				character[i].add(splits[j]);
			}
		} // input end;
		int index = 0;

		for (int i = 0; i < name.length; i++) {
			int flag = 0;
			for (int j = 0; j < purchased.length; j++) {
				if (name[i].equals(purchased[j])) { // 구매한 상품이 있으면 비교 시작
					flag = 1;
					// 우선순위 map에 담기 -> 제품의 특성을 담기
					for (int k = 0; k < character[i].size(); k++) {
						if (map.containsKey(character[i].get(k))) {
							int cnt = map.get(character[i].get(k)) + 1;
							map.put(character[i].get(k), cnt);
						} else
							map.put(character[i].get(k), 1);
					}
					break;
				}
			}
			if (flag == 0) {
				noPurchased[index] = i;
				index++;
			} // 구매한 상품에 없을 경우 구매 안한 목록으로 들어가기
		}

		for (String s : map.keySet()) {
			top.add(new node(s, map.get(s)));
		}
		Collections.sort(top);

		int a = noPurchased[0];

		for (int i = 0; i < noPurchased.length - 1; i++) {
			int b = noPurchased[i + 1];
			ArrayList<Integer> alist = new ArrayList<>();
			ArrayList<Integer> blist = new ArrayList<>();
			for (int j = 0; j < top.size(); j++) {
				for (int k = 0; k < character[a].size(); k++) {
					if (top.get(j).c.equals(character[a].get(k)))alist.add(j);
				}
				for (int k = 0; k < character[b].size(); k++) {
					if (top.get(j).c.equals(character[b].get(k)))
						blist.add(j);
				}
			}
			int size = Math.min(alist.size(), blist.size());
			int flag = 0;
			for (int j = 0; j < size; j++) {
				if (alist.get(j) < blist.get(j)) {
					answer = name[a];
					flag = 1;
					break;
				} else if (alist.get(j) > blist.get(j)) {
					answer = name[b];
					flag = 1;
					a = b;
					break;
				}
			}
			if (flag == 0) {
				if (alist.size() != size) {
					answer = name[a];
				} else {
					answer = name[b];
					a = b;
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {

		String[] products = { "towel red long thin", "blanket red thick short", "curtain red long wide",
				"mattress thick", "hat red thin", "pillow red long", "muffler blue thick long" };
		String[] purchased = { "blanket", "curtain", "hat", "muffler" };
		solution(products, purchased);
	}

}
