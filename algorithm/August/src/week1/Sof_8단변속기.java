package week1;

import java.util.*;
import java.io.*;


public class Sof_8단변속기
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int flag = 0; // 오름차순 1, 내림차순 -1, mixed 
        int a = Integer.parseInt(st.nextToken());
        for(int i=1;i<8;i++){
            int b = Integer.parseInt(st.nextToken());
            if (a < b)
                flag++;
            else if (a > b)
                flag--;
            a = b;
        }
        if (flag == 7)
            System.out.println("ascending");
        else if (flag == -7)
            System.out.println("descending");
        else 
            System.out.println("mixed");
    }
}