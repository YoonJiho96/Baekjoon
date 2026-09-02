import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] bf = before.toCharArray();
        char[] af = after.toCharArray();
        
        Arrays.sort(bf);
        Arrays.sort(af);
        
        return String.valueOf(bf).equals(String.valueOf(af)) ? 1:0;
    }
}