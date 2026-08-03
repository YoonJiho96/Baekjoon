import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {       
        boolean[] valid = new boolean[my_string.length()];
        for(int i=0; i<indices.length; i++) {
            valid[indices[i]] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<valid.length; i++) {
            if(!valid[i]) sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}