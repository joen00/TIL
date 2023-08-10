package week2;

import java.util.*;

public class PRO_배달 {

	static boolean visit[];
    static int dist[];
    static ArrayList<node>[] list;
    
    static class node implements Comparable<node>{
        int b, w;
        public node(int b, int w){
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(node o){
            return this.w - o.w;
        }
    }
    
    static void bfs(){
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()){
            node cur = pq.poll();
            for(node i : list[cur.b]){
                if (dist[i.b] > cur.w + i.w){
                    dist[i.b] =  cur.w + i.w;
                    pq.add(new node(i.b, dist[i.b]));
                }
            }
        }
        
        
        
    }
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N + 1];
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            list[a].add(new node(b, w));
            list[b].add(new node(a, w));
        } // input end
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs();
        //System.out.println(Arrays.toString(dist));
        for(int i=1;i<=N;i++){
            if (dist[i] <= K)
                answer++;
        }
        
        return answer;
    }
	
}
