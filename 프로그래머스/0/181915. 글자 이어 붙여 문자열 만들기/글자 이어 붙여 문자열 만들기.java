import java.util.*;

class Solution {
    public String solution(String my_string, int[] index_list) {       
        StringBuilder sb = new StringBuilder();
        char[] str = my_string.toCharArray();
        
        for(int i : index_list) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}