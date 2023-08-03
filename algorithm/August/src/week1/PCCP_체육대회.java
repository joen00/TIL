package week1;

import java.util.*;

class PCCP_체육대회 {
    
    static int path[];
    static int path1[];
    static int answer;
    static boolean visit[];
    
    
    static void calStats(int level, int[][] ability, int end){
        
        if (level == end){
            //System.out.println(Arrays.toString(path1));
            int sum = 0;
            for(int i=0;i<end;i++){
                sum = sum + ability[path[i]][path1[i]];
            }
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i=0;i<end;i++){
            if (visit[i]) continue;
            visit[i] = true;
            path1[level] = i;
            calStats(level + 1, ability, end);
            visit[i] = false;
            path1[level] = 0;
        }
        
    }
    
    static void dfs(int start, int level, int[][] ability, int end){
        
        if (level == end){
            visit = new boolean[end];
            path1 = new int[end];
            //System.out.println(Arrays.toString(path) + "-------");
            calStats(0, ability, end);
            return;
        }
        
        for(int i=start;i<ability.length;i++){
            path[level] = i;
            dfs(i + 1, level + 1, ability, end);
            path[level] = 0;
        }
        
    }
    
    public int solution(int[][] ability) {
        answer = 0;
        
        path = new int[ability[0].length];
        
        dfs(0,0,ability, ability[0].length);
        
        return answer;
    }
}