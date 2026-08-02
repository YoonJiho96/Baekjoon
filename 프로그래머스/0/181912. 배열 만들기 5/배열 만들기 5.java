import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = new int[intStrs.length];
        
        int idx = 0;
        for(String str : intStrs) {            
            int num = Integer.parseInt(str.substring(s, s+l));
            if(num > k) {
                answer[idx++] = num;
            }
        }
        
        return Arrays.copyOfRange(answer, 0, idx);
    }
}