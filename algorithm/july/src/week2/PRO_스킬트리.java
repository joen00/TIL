package week2;

import java.io.*;
import java.util.*;

public class PRO_스킬트리 {

	static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Stack<String> stack = new Stack<>();

		int arr[] = new int[200];

		for (int i = 0; i < skill_trees.length; i++) {
			int flag = 0;
			for (int s = skill.length() - 1; s >= 0; s--) {
				stack.push(skill.charAt(s) + "");
				arr[skill.charAt(s)] = 1;
			}
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (arr[skill_trees[i].charAt(j)] == 1) {
					if (stack.peek().equals(skill_trees[i].charAt(j) + "") == false) {
						flag = 1;
						break;
					} else if (stack.peek().equals(skill_trees[i].charAt(j) + "")) {
						stack.pop();
					}
				}
			}
			if (flag == 0) {
				//System.out.println(i);
				answer++;
			}
		}
		//System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {

		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		String skill = "CBD";
		solution(skill, skill_trees);

	}

}
