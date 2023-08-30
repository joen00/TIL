package week5;
import java.util.*;
public class PRO_무인도여행 {



	    
	    static boolean visit[][];
	    static String arr[][];
	    static int direct[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	    static int N, M;
	    
	    static int bfs(int startx, int starty){
	        Queue<node> q = new ArrayDeque<>();
	        q.add(new node(startx, starty));
	        visit[startx][starty] = true;
	        int cnt = 0;
	        
	        while (!q.isEmpty()){
	            node cur = q.poll();
	            cnt = cnt + Integer.parseInt(arr[cur.x][cur.y]);
	            for(int d=0;d<4;d++){
	                int dx = direct[d][0] + cur.x;
	                int dy = direct[d][1] + cur.y;
	                if (dx <0 || dy <0 || dx >= N || dy >= M)
	                    continue;
	                if (visit[dx][dy])
	                    continue;
	                if (arr[dx][dy].equals("X"))
	                    continue;
	                q.add(new node(dx, dy));
	                visit[dx][dy] = true;
	            }
	            
	        }
	        
	        
	        return cnt;
	    }
	    
	    static class node{
	        int x, y;
	        public node(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
	    
	    public int[] solution(String[] maps) {
	        
	        visit = new boolean[maps.length][maps[0].length()];
	        arr = new String[maps.length][maps[0].length()];
	        for(int i=0;i<maps.length;i++){
	            arr[i] = maps[i].split("");
	            // System.out.println(Arrays.toString(arr[i]));
	        }
	        N = arr.length;
	        M = arr[0].length;
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i=0;i<N;i++){
	            for(int j=0;j<M;j++){
	                if (arr[i][j].equals("X") || visit[i][j])
	                    continue;
	                list.add(bfs(i, j));
	            }
	        }
	        Collections.sort(list);
	        if (list.size() == 0){
	            int[] answer = {-1};
	            return answer;
	        }
	        int[] answer = new int[list.size()];
	        for(int i=0;i<list.size();i++){
	            answer[i] = list.get(i);
	        }
	        
	       
	        return answer;
	    }
	
}
