import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;

        String temp = B + B;
        if(temp.contains(A)) {
            int start = temp.indexOf(A);
            int last = temp.lastIndexOf(A);
            answer = Math.min(start, last);
        } else {
            return -1;
        }
        
        return answer;
    }
}