import java.util.*;

class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        
        char[] codes = code.toCharArray();
        for(int i=0; i<codes.length; i++) {
            if(i % q == r) {
                sb.append(codes[i]);
            }
        }
        return sb.toString();
    }
}