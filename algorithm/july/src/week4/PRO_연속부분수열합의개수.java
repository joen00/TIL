package week4;
import java.util.*;
public class PRO_연속부분수열합의개수 {
	public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int arr[] = new int[elements.length + elements.length - 1];
        for(int i=0;i<elements.length;i++){
            arr[i] = elements[i];
        }
        for(int i=0;i<elements.length - 1;i++){
            arr[elements.length + i] = elements[i];
        }
        // System.out.println(Arrays.toString(arr));
        
        for(int i=0;i<elements.length;i++){
            // 먼저 해당 길이만큼 넣어줄 슬라이딩 윈도우
            int sum = 0;
            for(int j=0;j<=i;j++){
                sum = sum + arr[j];
            } // 초기 세팅 완료
            set.add(sum);
            // System.out.println(sum);
            for(int j = 0; j < elements.length - 1; j++){
                sum = sum - arr[j];
                sum = sum + arr[j + i + 1];
                set.add(sum);
                // System.out.print(sum + " ");
            }
            // System.out.println();
        }
        
        // Iterator<Integer> it = set.iterator();
        // while (it.hasNext()){
        //     System.out.println(it.next());
        // }
        
        answer = set.size();
        
        return answer;
    }
}
