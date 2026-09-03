import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alp = new int[26];
        Arrays.fill(alp, Integer.MAX_VALUE);
        
        for(String map : keymap) {
            char[] m = map.toCharArray();
            for(int i=0; i<m.length; i++) {
                alp[m[i] - 'A'] = Math.min(i + 1, alp[m[i] - 'A']);
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i=0; i<answer.length; i++){
            int sum = 0;
            for(char c : targets[i].toCharArray()) {
                if(alp[c - 'A'] == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }else {
                    sum += alp[c - 'A'];
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}