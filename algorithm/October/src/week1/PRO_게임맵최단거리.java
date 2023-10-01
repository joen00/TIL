package week1;
import java.util.*;
import java.io.*;
public class PRO_게임맵최단거리 {
	 static int answer = -1;
	    static int direct[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	    static boolean visit[][];
	    
	    static void bfs(int[][] maps){
	        visit = new boolean[maps.length][maps[0].length];
	        Queue<node> q = new ArrayDeque<>();
	        q.add(new node(0,0));
	        visit[0][0] = true;
	        int cnt = 0;
	        while (!q.isEmpty()){
	            int size = q.size();
	            cnt++;
	            for(int s = 0; s<size;s++){
	                node cur = q.poll();
	                if (cur.x == maps.length - 1 && cur.y == maps[0].length - 1){
	                    answer = cnt;
	                    return;
	                }
	                for(int d = 0; d<4;d++){
	                    int dx = cur.x + direct[d][0];
	                    int dy = cur.y + direct[d][1];
	                    if (dx <0 || dy <0 || dx >= maps.length || dy >= maps[0].length)
	                        continue;
	                    if (visit[dx][dy] || maps[dx][dy] == 0)
	                        continue;
	                    visit[dx][dy] = true;
	                    q.add(new node(dx, dy));
	                }
	            }
	            
	        }
	        
	    }
	    
	    static class node{
	        int x, y;
	        public node(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
	    
	    
	    public int solution(int[][] maps) {
	        bfs(maps);
	        return answer;
	    }
}
