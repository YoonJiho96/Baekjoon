import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int q = 0; q < queries.length; q++) {
            int s = queries[q][0];
            int e = queries[q][1];
            int k = queries[q][2];
            
            int min = Integer.MAX_VALUE;
            for(int i=s; i<=e; i++) {
                int num = arr[i];
                if(num > k) min = Math.min(min, num);
            }
            
            answer[q] = min == Integer.MAX_VALUE? -1:min;
        }
        
        return answer;
    }
}