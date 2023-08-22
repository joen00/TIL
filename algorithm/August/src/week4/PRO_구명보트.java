package week4;

import java.util.*;

public class PRO_구명보트 {

	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        boolean visit[] = new boolean[people.length];
        
        int k = people.length;
        int start = 0;
        for(int i=0;i<people.length;i++){
            start = i;
            int left = i + 1;
            int right = k - 1;
            int mid = 0;
            k = 0;
            while(left <= right){
                mid = (left + right) / 2;
                if (people[start] + people[mid] <= limit){
                    k = mid;
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            if (k == 0)
                break;
            visit[k] = true;
            answer++;
        }
    
        for(int i= start; i< people.length;i++){
            if (visit[i])
                continue;
            answer++;
        }   
        
       
        return answer;
    }

}
