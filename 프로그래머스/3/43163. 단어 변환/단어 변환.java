import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        set.add(begin);
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s=0; s<size; s++) {
                String cur = queue.poll();
            
                if(cur.equals(target)) {
                    return count;
                }

                for(String w : words) {
                    if(set.contains(w)) continue;

                    int diff = 0;
                    for(int i=0; i<w.length(); i++) {
                        if(cur.charAt(i) != w.charAt(i)) {
                            diff++;
                        }
                    }

                    if(diff == 1) {
                        queue.offer(w);
                        set.add(w);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}