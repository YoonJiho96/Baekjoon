import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numLog.length-1; i++) {
            int cur = numLog[i];
            int next = numLog[i+1];
            
            int gap = cur - next;
            if(gap==1)  sb.append("s");
            else if(gap==-1) sb.append("w");
            else if(gap==10) sb.append("a");
            else if(gap==-10) sb.append("d");
        }
        
        return sb.toString();
    }
}