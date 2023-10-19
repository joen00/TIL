package week2;

public class PRO_롤케이크자르기 {

	public int solution(int[] topping) {
        int answer = 0;
        int arrA[] = new int[10000];
        int arrB[] = new int[10000];
        int sizeA = 0;
        int sizeB = 0;
        for(int i=0;i<topping.length;i++){
            arrA[topping[i]-1]++;
        }
        for(int i=0;i<10000;i++){
            if(arrA[i] > 0)
                sizeA++;
        }
        
        for(int i=0;i<topping.length;i++){
            int a = topping[i] - 1;
            arrA[a]--;
            arrB[a]++;
            if (arrA[a] == 0)
                sizeA--;
            if (arrB[a] == 1)
                sizeB++;
            if (sizeA == sizeB)
                answer++;
        }
        
        return answer;
    }

}
