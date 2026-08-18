import java.util.*;

class Solution {
    public String solution(String s) {
        int[] alp = new int[26];
        
        for(char c : s.toCharArray()) {
            alp[(int) (c - 'a')]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<alp.length; i++) {
            if(alp[i] == 1) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}