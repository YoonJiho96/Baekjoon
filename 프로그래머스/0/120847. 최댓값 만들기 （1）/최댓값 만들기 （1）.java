import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int prev = 0;
        int max = 0;
        
        for(int n : numbers) {
            if(max < n) {
                prev = max;
                max = n;
            }else if(prev < n) {
                prev = n;
            }
        }
        
        return prev * max;
    }
}