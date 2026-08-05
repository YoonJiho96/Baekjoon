import java.util.*;

class Solution {
    static String[] str = {"aya", "ye", "woo", "ma"};
    HashSet<String> set = new HashSet<>();

    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=1; i<=4; i++) {
            boolean[] selected = new boolean[4];
            dfs(0, i, selected, "");
        }
        
        for(String s : babbling) {
            if(set.contains(s)) answer++;
        }
        
        return answer;
    }
    
    void dfs(int depth, int limit, boolean[] selected, String currentStr) {
        if(depth == limit) {
            set.add(currentStr);
            return;
        }
        
        for(int i=0; i<4; i++) {
            if(selected[i]) continue;
            
            selected[i] = true;
            dfs(depth + 1, limit, selected, currentStr + str[i]);
            selected[i] = false;
        }
    }
}