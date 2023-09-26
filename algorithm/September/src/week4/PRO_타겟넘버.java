package week4;

public class PRO_타겟넘버 {
	static int answer;
    static int check[];
    
    static void dfs(int level, int sum, int target, int[] numbers){
        

        if (level == numbers.length){
           
            if (sum == target)
                answer++;
            return;
        }
        
        
        dfs(level + 1, sum + numbers[level], target, numbers);
  
        dfs(level + 1, sum - numbers[level], target, numbers);

    }
    
    
    public int solution(int[] numbers, int target) {
        
        check = new int[10000];
        dfs(0, 0, target, numbers);
        
        return answer;
        
        
    }
}
