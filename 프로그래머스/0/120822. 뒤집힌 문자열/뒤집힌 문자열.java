import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] str = my_string.toCharArray();
        for(int i=str.length-1; i>=0; i--) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}