import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] str = my_string.toLowerCase().toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
}