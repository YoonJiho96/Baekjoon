import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int prev = stack.pop();
            answer[prev] = (n - 1) - prev;
        }
        
        return answer;
    }
}