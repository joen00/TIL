package week1;

public class PRO_네트워크 {
static int arr[];
    
    static int findboss(int a){
        if (arr[a] == 0)
            return a;
        return arr[a] = findboss(arr[a]);
    }
    
    static void setUnion(int a, int b){
        int fa = findboss(a);
        int fb = findboss(b);
        if (fa == fb)return;
        arr[fb] = fa;
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        arr = new int[computers.length];
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if (i != j && computers[i][j] == 1){
                    if (findboss(i) != findboss(j))
                        setUnion(i, j);
                }
            }
        }
        
        for(int i=0;i<computers.length;i++){
            if (arr[i] == 0)
                answer++;
        }
        
        return answer;
    }
}
