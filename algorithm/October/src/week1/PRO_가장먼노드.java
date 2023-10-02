package week1;
import java.util.*;
import java.io.*;
public class PRO_가장먼노드 {
	static ArrayList<Integer> list[];
    static int visit[];
    static int MAX = 0;
    static class node{
        int x, y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visit[1] = 1;
        int cnt = 0;
        while (!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int s = 0; s<size;s++){
                int cur = q.poll();
                for(int index : list[cur]){
                    if (visit[index] == 0){
                        visit[index] = cnt;
                        MAX = cnt;
                        q.add(index);
                    }
                }
            }
        }
        
        return cnt;
        
    }
    
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new ArrayList[n + 1];
        visit = new int[n + 1];
        for(int i=0;i <= n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i < edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        } 
        bfs();
    
        for(int i=2;i<n+1;i++){
            if (visit[i] == MAX)
                answer++;
        }
        return answer;
    }
}
