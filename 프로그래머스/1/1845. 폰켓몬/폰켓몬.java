import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int limit = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        answer = Math.min(set.size(), limit);
        
        return answer;
    }
}