import java.util.*;

class Solution {
    char[] moum = {'A', 'E', 'I', 'O', 'U'};
    String target;
    public int solution(String word) {
        target = word;
        dfs("");
        return cnt;
    }
    
    int cnt = 0;
    boolean dfs(String str) {
        if(str.equals(target)) {
            return true;
        }
        
        if(str.length() >= 5) {
            return false;
        }
        
        for(int i=0; i<5; i++) {
            cnt++;
            
           if(dfs(str + moum[i])) {
               return true;
           } 
        }
        
        return false;
    }
}