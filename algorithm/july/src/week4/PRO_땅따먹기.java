package week4;

import java.io.*;
import java.util.*;

class PRO_땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        //System.out.println("Hello Java");
        
        int check[]= new int[4];
        for(int i=0;i<4;i++){
            check[i] = land[0][i];
        }
        for(int i=1;i<land.length;i++){
            int flag[] = new int[4];
            for(int k=0;k<4;k++){
                flag[k] = check[k];
            }
            for(int j=0;j<land[i].length;j++){
                int MAX = 0;
                for(int k=0;k<4;k++){
                    if (j == k) continue;
                    else MAX = Math.max(MAX, flag[k]);
                }
                check[j] = MAX + land[i][j];
            }
            //System.out.println(Arrays.toString(check));
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer, check[i]);
        }
        //System.out.println(answer);
        return answer;
    }
}
