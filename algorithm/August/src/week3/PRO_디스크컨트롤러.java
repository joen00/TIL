package week3;

import java.util.*;

public class PRO_디스크컨트롤러 {
	static class node implements Comparable<node>{
        int x, y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(node o){
            return this.y - o.y;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<node> pq = new PriorityQueue<>();
        int time = 0;
        int index = 0;
        int size = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        while (true){
            if (size >= jobs.length)
                break;
            
            for(int i=index; i<jobs.length;i++){
                if (jobs[i][0] <= time){
                    pq.add(new node(jobs[i][0], jobs[i][1]));
                    index++;
                }
            }
            
            if (pq.isEmpty()){
                time = jobs[index][0];
            }else{
                node cur = pq.poll();
                answer = answer + cur.y + time - cur.x;
                time = time + cur.y;
                size++;
            }
            
        }
        answer = answer/jobs.length;
        
        return answer;
    }
}
