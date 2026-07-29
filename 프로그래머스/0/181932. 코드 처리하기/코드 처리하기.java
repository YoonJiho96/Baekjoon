import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        
        char[] str = code.toCharArray();
        int mode = 0;
        
        for(int i=0; i<str.length; i++) {
            if(str[i] == '1') {
                mode ^= 1;
            } else {
                if(mode == 0) {
                    if(i % 2 == 0) {
                        sb.append(str[i]);
                    }
                } else {
                    if(i % 2 != 0) {
                        sb.append(str[i]);
                    }
                }
            }
        }
        
        if(sb.isEmpty()) return "EMPTY";
        return sb.toString();
    }
}