package week5;

public class 단어변환 {

	static int MIN = 0;
    static boolean visit[];
    
    
    static boolean check(String str1, String str2){
        
        int flag = 0;
        
        for(int i=0;i<str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i)){
                flag++;
            }
        }
        if (flag == 1)
            return true;
        return false;
    }
    
    static void dfs(int level, String str, String target, String words[]){
        
        if (level > words.length)
            return;
        if (str.equals(target)){
            MIN = level;
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if (visit[i])
                continue;
            if (check(str, words[i])){
                visit[i] = true;
                dfs(level + 1, words[i], target, words);
                visit[i] = false;
            }
                
        }
        
    }
    
    
    public int solution(String begin, String target, String[] words) {
        
        
        visit = new boolean[words.length];
        dfs(0, begin, target, words);
        
        return MIN;
    }

}
