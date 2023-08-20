package week3;

import java.util.*;
public class PRO_이중우선순위큐 {

	public int[] solution(String[] operations) {
        
        
        PriorityQueue<Integer> pqMIN = new PriorityQueue<>();
        PriorityQueue<Integer> pqMAX = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<operations.length;i++){
            String str[] = operations[i].split(" ");
            String a = str[0];
            int b = Integer.parseInt(str[1]);
            // System.out.println(a + " " + b);
            if (a.equals("I")){
                if (!map.containsKey(b))
                    map.put(b, 1);
                else
                    map.put(b, map.get(b) + 1);
                pqMAX.add(b);
                pqMIN.add(b);
            } // I 명령어
            else if (a.equals("D") && b == 1){
                while (!pqMAX.isEmpty()){
                    int cur = pqMAX.poll();
                    if (map.containsKey(cur)){
                        if (map.get(cur) == 1)
                            map.remove(cur);
                        else
                            map.put(cur, map.get(cur) - 1);
                        break;
                    }
                }
            } // D 1 명령어
            else if (a.equals("D") && b == -1){
                while (!pqMIN.isEmpty()){
                    int cur = pqMIN.poll();
                    if (map.containsKey(cur)){
                        if (map.get(cur) == 1)
                            map.remove(cur);
                        else
                            map.put(cur, map.get(cur) - 1);
                        break;
                    }
                }
            }// D -1 명령어
        }
        
        
        int[] answer = new int[2];
        if (pqMAX.size() == 0 || pqMIN.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            int MAX = 0;
            while (!pqMAX.isEmpty()){
                MAX = pqMAX.poll();
                if (map.containsKey(MAX))
                    break;
            }
            int MIN = 0;
            while (!pqMIN.isEmpty()){
                MIN = pqMIN.poll();
                if (map.containsKey(MIN))
                    break;
            }
            answer[0] = MAX;
            answer[1] = MIN;
        }
            
            
        
        return answer;
    }

}
