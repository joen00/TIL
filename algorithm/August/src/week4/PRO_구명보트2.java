package week4;
import java.util.*;
public class PRO_구명보트2 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right){
            if (people[left] + people[right] <= limit){
                left++;
                right--;
            }else
                right--;
            answer++;
        }
       
        return answer;
    }
}
