import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}