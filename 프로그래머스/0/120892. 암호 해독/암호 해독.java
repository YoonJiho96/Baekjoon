import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    
    public String solution(String cipher, int code) {
        for(int i=code - 1; i<cipher.length(); i += code) {
            sb.append(cipher.charAt(i));
        }
        return sb.toString();
    }
}