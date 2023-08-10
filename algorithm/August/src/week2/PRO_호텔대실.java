package week2;

import java.util.*;
class PRO_호텔대실 {
    
    static ArrayList<node>[] list;
    static ArrayList<node> bookList;
    
    static class node implements Comparable<node>{
        int a, b;
        public node(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(node o){
            if (this.a == o.a)
                return this.b - o.b;
            else
                return this.a - o.a;
        }
        
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        list = new ArrayList[book_time.length];
        
        bookList = new ArrayList<>();
        for(int i=0;i<book_time.length;i++){
            String strA[] = book_time[i][0].split(":");
            String strB[] = book_time[i][1].split(":");
            int a = Integer.parseInt(strA[0]) * 60 + Integer.parseInt(strA[1]);
            int b = Integer.parseInt(strB[0]) * 60 + Integer.parseInt(strB[1]) + 10;
            bookList.add(new node(a, b));
            list[i] = new ArrayList<>();
        }
        
        Collections.sort(bookList);
        list[0].add(new node(bookList.get(0).a, bookList.get(0).b));
        // 첫번째 넣고 시작하기
        
        int size = 1;
        for(int i=1;i<book_time.length;i++){
            int a = bookList.get(i).a;
            int b = bookList.get(i).b;
            
            int check = 0; // 새로운 곳에 넣어야 하는지 체크
            for(int j = 0; j < size; j++){
                int flag = 0; // 만약 1이면 겹친다. 그곳으로 못감
                for(int k = 0; k<list[j].size(); k++){
                    int c = list[j].get(k).a;
                    int d = list[j].get(k).b;
                    if ((c <= a && d > a) || (c <= b && d >= b)){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    check = 1; // 새로운 방 안만들어줘도 됨
                    list[j].add(new node(a, b));
                    break;
                }
            }
            
            if (check == 0){
                list[size].add(new node(a, b));
                size++;
            }
            
        }
        
        answer  = size;
        
        return answer;
    }
}