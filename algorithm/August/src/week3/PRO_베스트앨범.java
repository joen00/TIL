package week3;
import java.util.*;
public class PRO_베스트앨범 {

	static ArrayList<node> list;
    static HashMap<String, Integer> genreCount;
    
    static class node implements Comparable<node>{
        String genre;
        int play, totalplayCount, num;
        
        public node(String genre,int play, int totalplayCount,int num){
            this.genre =genre;
            this.play =play;
            this.totalplayCount =totalplayCount;
            this.num =num;
        }
        
        @Override
        public int compareTo(node o){
            if (this.totalplayCount == o.totalplayCount){
                if (this.play == o.play)
                    return this.num - o.num;
                else
                    return o.play - this.play;
            }else
                return o.totalplayCount - this.totalplayCount;
        }
        
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
     
        list = new ArrayList<>();
        genreCount = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            list.add(new node(genre, play, 0, i));
            if (!genreCount.containsKey(genre))
                genreCount.put(genre, play);
            else
                genreCount.put(genre, genreCount.get(genre) + play);
        }
        
        for(int i=0;i<genres.length;i++){
            String genre = list.get(i).genre;
            int totalplayCount = genreCount.get(genre);
            list.get(i).totalplayCount = totalplayCount;
        }
        
        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<>();
        String bgenre = list.get(0).genre;
        int flag = 0;
        result.add(list.get(0).num);
        
        for(int i=1;i<genres.length;i++){
            String genre = list.get(i).genre;
            if (genre.equals(bgenre) && flag == 0){
                result.add(list.get(i).num);
                flag = 1;
            }else if (genre.equals(bgenre) && flag != 0)
                continue;
            else if (!genre.equals(bgenre)){
                result.add(list.get(i).num);
                flag = 0;
            }
            bgenre = genre;
        }
        
        int answer[] = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }

}
