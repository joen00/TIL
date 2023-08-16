package week3;
import java.util.*;
public class PRO_섬연결하기 {

	static ArrayList<node>[] list;
    static int dist[];
    
    static class node implements Comparable<node>{
        int y, w;
        
        public node(int y, int w){
            this.y = y;
            this.w = w;
        }
        
        @Override
        public int compareTo(node o){
            return this.w - o.w;
        }
        
    }
    
    
    static void bfs( int[][] costs){
        
        PriorityQueue<node> pq = new PriorityQueue<>();
        dist[costs[0][0]] = 0;
        pq.add(new node(costs[0][0], 0));
        
        while (!pq.isEmpty()){
            node cur = pq.poll();
            for(node i : list[cur.y]){
                if (dist[i.y] > cur.w + i.w){
                    dist[i.y] = cur.w + i.w;
                    pq.add(new node(i.y, dist[i.y]));
                }
            }
        }
        
        
    }
    
    public int solution(int n, int[][] costs) {
        
        list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<costs.length;i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int w = costs[i][2];
            list[x].add(new node(y, w));
        } // input end
        
        bfs(costs);
        int answer = 0;
        System.out.println(Arrays.toString(dist));
        for(int i=0;i<n;i++){
            answer = answer + dist[i];
        }
        
        return answer;
    }

}
