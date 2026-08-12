import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<answer.length; i++) {
            String q = quiz[i];
            
            String[] str = q.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            int c = Integer.parseInt(str[4]);
            
            int result = 0;
            if(str[1].equals("+")){
                result = a + b;
            } else {
                result = a - b;
            }

            answer[i] = result == c ? "O":"X";
        }
        
        return answer;
    }
}