import java.util.*;

class Solution {
    static String[] vowel = {"A", "E", "I", "O", "U"};
    static String target;
    int answer = 0;
    int count = 0;
    
    public int solution(String word) {    
        target = word;
        
        dfs("");
        
        return answer;
    }
    
    void dfs(String str) {
        if(str.equals(target)) {
            answer = count;
            return;
        }
        
        if(str.length() == 5) {
            return;
        }
        
        for(int i=0; i<vowel.length; i++) {
            String next = str + vowel[i];
            count++;
            dfs(next);
        }
    }
}