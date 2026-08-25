import java.util.*;

class Solution {
    String[] tgt;
    boolean[] selected;
    int answer = 0;
    HashSet<String> set = new HashSet<>();
    
    public int solution(String[] spell, String[] dic) {
        for(String d : dic) {
            set.add(d);
        }
        
        tgt = new String[spell.length];
        selected = new boolean[spell.length];
        dfs(spell, 0);
        
        return answer >= 1?1:2;
    }
    
    void dfs(String[] spell, int dep) {
        if(dep == tgt.length) {
            String str = String.join("", tgt);
            if(set.contains(str)) {
                answer++;
            }
            return;
        }
        
        for(int i=0; i<tgt.length; i++) {
            if(selected[i]) continue;
            
            selected[i] = true;
            tgt[dep] = spell[i];
            dfs(spell, dep + 1);
            selected[i] = false;
        }
    }
}