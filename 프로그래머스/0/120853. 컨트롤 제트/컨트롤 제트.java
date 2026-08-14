import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(String c : s.split(" ")) {
            if(c.equals("Z")) {
                stack.pop();
            }else {
                stack.push(Integer.parseInt(c));
            }
        }
        
        int answer = 0;
        for(int n : stack) {
            answer += n;
        }
        
        return answer;
    }
}