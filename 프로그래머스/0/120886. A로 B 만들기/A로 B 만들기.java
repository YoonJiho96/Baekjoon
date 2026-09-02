import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] bf = before.toCharArray();
        char[] af = after.toCharArray();
        
        Arrays.sort(bf);
        Arrays.sort(af);
        
        for(int i=0; i<bf.length; i++) {
            if(bf[i] != af[i]) {
                return 0;
            }
        }
        
        return 1;
    }
}