package week4;

public class PRO_JadenCase  {
    public String solution(String s) {
        String answer = "";
        
        
        for(int i=0;i<s.length();i++){
            if (i == 0 && (s.charAt(i) >= 'a'&& s.charAt(i) <= 'z')){
                char a = (char)(s.charAt(i) + 'A' - 'a');
                answer =  answer + a;
            }else if (i > 0 && s.charAt(i - 1) == ' '&& (s.charAt(i) >= 'a'&& s.charAt(i) <= 'z')){
                char a = (char)(s.charAt(i) + 'A'- 'a');
                answer =  answer + a;
            }else if (i > 0 && s.charAt(i - 1) != ' '&& (s.charAt(i) >= 'A'&& s.charAt(i) <= 'Z')){
                char a = (char)(s.charAt(i) + 'a'- 'A');
                answer =  answer + a;
            }else{
                char a = s.charAt(i);
                answer =  answer + a;
            }
                
        }
        // System.out.println(answer);
        return answer;
    }
}