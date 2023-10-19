package week2;

public class PRO_N퀸 {

	  static boolean visit[];
	    static int answer;
	    static void dfs(int level, int arr[], int N){
	        

	        if (level == N)
	            answer++;
	        // System.out.println(Arrays.toString(arr) + " " + level + " " + answer);
	        for(int i=0;i<N;i++){
	            int check = 0;
	            for(int j=0;j<level;j++){
	                if (i == arr[j] || (Math.abs(i - arr[j]) == Math.abs(j - level))){
	                    check = 1;
	                    break;
	                }
	            }
	            if (check == 0){
	                arr[level] = i;
	                dfs(level + 1, arr, N);
	                arr[level] = 0;
	            }
	        }
	        
	    }
	    
	    public int solution(int n) {

	        int arr[] = new int[n];

	        dfs(0,arr,n);
	 
	        return answer;
	    }

}
