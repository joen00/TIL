package week2;
import java.util.*;
public class PRO_광물캐기 {
	static class node implements Comparable<node>{
        int dia, iron, stone;
        public node(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        @Override
        public int compareTo(node o){
            if (this.dia == o.dia){
                if (this.iron == o.iron)
                    return o.stone - this.stone;
                else
                    return o.iron - this.iron;
            }
            return o.dia - this.dia;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayList<node> list = new ArrayList<>();
        int size = picks[0] + picks[1] + picks[2];
        int cnt = 0;
        for(int i=0;i<minerals.length;i= i+5){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            if (cnt >= size)
                break;
            for(int j=0; j<5;j++){
                if (i+j>=minerals.length)
                    break;
                if (minerals[i+j].equals("diamond"))
                    dia++;
                else if (minerals[i+j].equals("iron"))
                    iron++;
                else
                    stone++;
            }
            list.add(new node(dia, iron, stone));
            cnt++;
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).dia + " "+list.get(i).iron + " "+list.get(i).stone + " ");
        }
        int index = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<picks[i];j++){
                if (index >= list.size())
                    break;
                if (i == 0){
                    answer = answer + list.get(index).dia + list.get(index).iron + list.get(index).stone;
                }else if (i == 1){
                    answer = answer + (list.get(index).dia  * 5 )+ list.get(index).iron + list.get(index).stone;
                }else if (i == 2){
                    answer = answer + (list.get(index).dia  * 25 )+ (list.get(index).iron * 5)+ list.get(index).stone;
                }
                // System.out.println(answer + "index : " + index);
                index++;
            }
        }
        
        return answer;
    }
}
