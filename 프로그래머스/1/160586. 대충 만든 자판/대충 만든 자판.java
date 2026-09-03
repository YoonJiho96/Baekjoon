import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {       
        HashMap<Character, Integer> map = new HashMap<>();
        for(String key : keymap) {
            char[] k = key.toCharArray();
            for(int i=0; i<k.length; i++) {
                if(map.containsKey(k[i])) {
                   map.put(k[i], Math.min(i+1, map.get(k[i]))); 
                }else {
                    map.put(k[i], i+1);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i=0; i<answer.length; i++) {
            int sum = 0;
            for(char c : targets[i].toCharArray()) {
                if(!map.containsKey(c)) {
                    sum = -1;
                    break;
                }else {
                    sum += map.get(c);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}