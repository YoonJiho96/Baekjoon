import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<emergency.length; i++) {
            map.put(emergency[i], i);
        }
        
        Arrays.sort(emergency);
        
        for(int i=0; i<emergency.length; i++) {
            answer[i] = emergency.length - map.get(emergency[i]);
        }
        return answer;
    }
}