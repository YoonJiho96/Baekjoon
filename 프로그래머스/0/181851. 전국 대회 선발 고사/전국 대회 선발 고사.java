import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<rank.length; i++) {
            if(attendance[i])
                map.put(rank[i], i);
        }
        
        ArrayList<Integer> ranks = new ArrayList<>(map.keySet());
        Collections.sort(ranks);
        int a = map.get(ranks.get(0));
        int b = map.get(ranks.get(1));
        int c = map.get(ranks.get(2));
        
        
        return 10000 * a + 100 * b + c;
    }
}