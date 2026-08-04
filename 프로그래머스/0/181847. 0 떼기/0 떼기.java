import java.util.*;

class Solution {
    public String solution(String n_str) {
        int idx = 0;
        
        char[] str = n_str.toCharArray();
        for(int i=0; i<str.length; i++) {
            if(str[i] != '0') {
                idx = i;
                break;
            }
        }
        
        String answer = n_str.substring(idx);
        
        return answer;
    }
}