package week1;

import java.util.*;

class PCCCP_외톨이알파벳 {
    
    static class node{
        int cnt, part;
        
        public node(int cnt, int part){
            this.cnt = cnt;
            this.part = part;
        }
    }
    
    public String solution(String input_string) {
        String answer = "";
        HashMap<String, node> map = new HashMap<>();
        String[] arr = input_string.split("");
        String front = arr[0];
        // map.put(front, new node(1,0));
        // System.out.println(map.get(front).cnt);
        for(int i=1;i<arr.length;i++){
            String back = arr[i];
            if (front.equals(back)){
                if (map.containsKey(front)){
                    int cnt = map.get(front).cnt;
                    int part = map.get(front).part;
                    map.put(front, new node(cnt + 1,part));
                }else{
                    map.put(front, new node(1,0));
                }
            }else {
                 if (map.containsKey(front)){
                    int cnt = map.get(front).cnt;
                    int part = map.get(front).part;
                    map.put(front, new node(cnt + 1,part + 1));
                }else{
                    map.put(front, new node(1,1));
                 }
            }
            front = back;
        }
        
        String back = arr[arr.length - 1];
        if (map.containsKey(back)){
            int cnt = map.get(back).cnt;
            int part = map.get(back).part;
            map.put(back, new node(cnt + 1,part + 1));
        }else{
            map.put(back, new node(1, 1));
        }

        
        for(String s : map.keySet()){
            // System.out.println(s + " : cnt = " + map.get(s).cnt + ",  part = " + map.get(s).part);
            if (map.get(s).cnt >= 2 && map.get(s).part >= 2){
                answer = answer + s;
            }
        }
        if (answer.length() == 0){
            answer = "N";
        }
        //System.out.println(map);
        
        return answer;
    }
}