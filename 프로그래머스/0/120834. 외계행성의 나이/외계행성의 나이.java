import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String value = String.valueOf(age);
        for(char c : value.toCharArray()) {
            sb.append((char) (c - '0' + 'a'));
        }
        return sb.toString();
    }
}