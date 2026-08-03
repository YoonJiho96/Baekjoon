import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        int idx = c - 1;
        while(idx < my_string.length()) {
            sb.append(my_string.charAt(idx));
            idx += m;
        }
        
        return sb.toString();
    }
}