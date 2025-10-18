import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(now.depth >= numbers.length) {
                if(now.sum == target) {
                    answer++;
                }
                continue;
            }
            
            queue.offer(new Node(now.sum + numbers[now.depth], now.depth + 1));
            queue.offer(new Node(now.sum - numbers[now.depth], now.depth + 1));
        }
        
        return answer;
    }
}

class Node {
    int sum;
    int depth;
    
    Node(int sum, int depth) {
        this.sum = sum;
        this.depth = depth;
    }
}