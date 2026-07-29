import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int n : arr) {
            deque.offer(n);
        }
        
        for(int i=0; i<query.length; i++) {
            if(i % 2 == 0) {
                int n = deque.size() - query[i] - 1;
                while(n-- > 0) {
                    deque.pollLast();
                }
            } else {
                int n = query[i];
                while(n-- >0) {
                    deque.pollFirst();
                }
            }
        }
        
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}