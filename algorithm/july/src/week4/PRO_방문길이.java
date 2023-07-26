
package week4;
import java.util.*;
class Solution {
    
    static int direct[][] ={{-1,0},{1,0},{0,-1},{0,1}}; //UDLR
    static List<node> visit;
    
    static class node{
        int sx, sy, ex, ey;
        
        public node(int sx, int sy,int ex,int ey){
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
        
        @Override
        public boolean equals(Object o){
            node n = (node)o;
            if (n.sx == this.sx && n.sy == this.sy && n.ex == this.ex && n.ey == this.ey)
                return true;
            else if (n.sx == this.ex && n.sy == this.ey && n.ex == this.sx && n.ey == this.sy)
                return true;
            return false;
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
  
        visit = new ArrayList<>();
        int sx = 0;
        int sy = 0;
        for(int i=0;i<dirs.length();i++){
            int dx = 0;
            int dy = 0;
            if (dirs.charAt(i) == 'U'){
                dx = direct[0][0] + sx;
                dy = direct[0][1] + sy;
            }else if (dirs.charAt(i) == 'D'){
                dx = direct[1][0] + sx;
                dy = direct[1][1] + sy;
            }else if (dirs.charAt(i) == 'L'){
                dx = direct[2][0] + sx;
                dy = direct[2][1] + sy;
            }else if (dirs.charAt(i) == 'R'){
                dx = direct[3][0] + sx;
                dy = direct[3][1] + sy;
            }
            
            if (dx < -5 || dy < -5 || dx > 5 || dy > 5)continue;
            
            if (!visit.contains(new node(sx, sy, dx, dy))){
                // System.out.println(dx + ", " +dy);
                visit.add(new node(sx, sy, dx, dy));
                answer++;
            }           
            sx = dx;
            sy = dy;
        }
        return answer;
    }
}