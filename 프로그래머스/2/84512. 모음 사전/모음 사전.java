import java.util.*;

class Solution {
    char[] moum = {'A', 'E', 'I', 'O', 'U'};
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String word) {
        dfs(0, "");
        return map.get(word);
    }
    
    int cnt = 0;
    void dfs(int len, String str) {
        map.put(str, cnt);
        if(len >= 5) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            cnt++;
            dfs(len + 1, str + moum[i]);
        }
    }
}