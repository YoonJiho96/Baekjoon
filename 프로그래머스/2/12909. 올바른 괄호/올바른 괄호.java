import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] inputs = s.toCharArray();
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : inputs) {
            if(c == '(') {
                stack.offer(c);
            }else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                
                char last = stack.pollLast();
                
                if(last == ')') {
                    stack.offer(last);
                }
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}