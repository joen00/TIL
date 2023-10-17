package week2;

public class PRO_연속된부분수열의합 {

	public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int MIN = Integer.MAX_VALUE;
        int sum = 0;
        while (true){
            if (sum >= k){
                sum = sum - sequence[start];
                start++;
            } else if (end >= sequence.length)
                break;
            else if (sum < k){
                sum = sum + sequence[end];
                end++;
            } 
            
            if (sum == k){
                if (MIN > (end - start)){
                    MIN = end - start;
                    answer[0] = start;
                    answer[1] = end - 1;
                }
            }
        }
        
        
        return answer;
    }
}
