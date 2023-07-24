package week4;

class PRO_숫자의표현 {
    public int solution(int n) {
       // n = 14;
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int sum = 0;
            int flag = i;
            while (true){
                if (sum == n){
                    answer++;
                    break;
                }
                if (sum > n) break;
                sum = sum + flag;
                flag++;
                
            }
            
        }
        //System.out.println(answer);
        return answer;
    }
}