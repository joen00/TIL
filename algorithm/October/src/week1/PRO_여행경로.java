package week1;
import java.util.*;
public class PRO_여행경로 {
	  static class node implements Comparable<node>{
	        String a, b;
	        public node(String a, String b){
	            this.a = a;
	            this.b = b;
	        }
	        @Override
	        public int compareTo(node o){
	            if (o.a.equals(this.a))
	                return this.b.compareTo(o.b);
	            else return this.a.compareTo(o.a);
	        }
	    }
	    
	    static ArrayList<node> list;
	    static boolean visit[];
	    static String result[];
	    static String answer[];
	    static int flag;
	    
	    static void dfs(int level, String start){
	        
	        if (level == list.size() + 1){         
	            for(int i=0;i<list.size() + 1;i++){
	                answer[i] = result[i];
	            }
	            flag = 1;
	            return;
	        }
	        if (flag == 1)
	            return;
	        // System.out.println(Arrays.toString(result) + " " + start);
	        
	        for(int i=0;i<list.size();i++){
	            if (!visit[i] && list.get(i).a.equals(start)){
	                // System.out.println("여기");
	                visit[i] = true;
	                result[level] = list.get(i).b;
	                dfs(level + 1, list.get(i).b);
	                visit[i] = false;
	                result[level] = "";
	            }
	        }
	        
	    }
	    
	    
	    public String[] solution(String[][] tickets) {
	        answer = new String[tickets.length + 1];
	        result = new String[tickets.length + 1];
	        list = new ArrayList<>();
	        visit = new boolean[tickets.length];
	        for(int i=0;i<tickets.length;i++){
	            String a = tickets[i][0];
	            String b = tickets[i][1];
	            list.add(new node(a, b));
	        }
	        Collections.sort(list);
	        // for(int i=0;i<tickets.length;i++){
	        //     System.out.println(list.get(i).a +" " +list.get(i).b);
	        // }
	        result[0] = "ICN";
	        
	        dfs(1, "ICN");
	        
	        
	        return answer;
	    }
}
