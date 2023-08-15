package week3;

import java.util.*;

class PRO_미로탈출명령어 {
    
    
    static ArrayList<String> list;
    static int direct[][] = {{1,0},{0,-1},{0,1}, {-1,0}}; // d l r u
    static String s[] = {"d","l","r","u"};
    static int flag;
    
    static void dfs(int x, int y, int endx, int endy, int level, int k, String str, int n, int m){
        
        if (flag == 1)
            return;
        if (k < level + Math.abs(endx - x) + Math.abs(endy - y))
            return;
        if (level > k)
            return;
        if (level == k && x == endx && y == endy){
            list.add(str);
            flag = 1;
            return;
        }

        for(int i = 0; i< 4; i++){
            int dx = direct[i][0] + x;
            int dy = direct[i][1] + y;
            if (dx <0 || dy <0 || dx>= n || dy>=m)
                continue;
            dfs(dx, dy, endx, endy, level + 1, k, str + s[i], n, m);
        }
        
    }

    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        list = new ArrayList<>();
        
        if ((k - (Math.abs(x-r) + Math.abs(y-c))) % 2 == 1 || (Math.abs(x-r) + Math.abs(y-c)) > k){
            answer = "impossible";
        }else {
            flag = 0;
            dfs(x-1,y-1,r-1,c-1,0,k,"",n,m);
            if(list.size() == 0)
                answer = "impossible";
            else{
                answer = list.get(0);
            }
        }
        
        
            
        
        return answer;
    }
}
