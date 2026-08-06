import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(friends[i], i);
        }
        
        int[][] gift = new int[n][n];
        int[] point = new int[n];
        for(String g : gifts) {
            String[] cmd = g.split(" ");
            int from = map.get(cmd[0]);
            int to = map.get(cmd[1]);
            
            gift[from][to]++;
            point[from]++;
            point[to]--;
        }
        
        int[] nextGift = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int aTob = gift[i][j];
                int bToa = gift[j][i];
                
                if(aTob > bToa) {
                    nextGift[i]++;
                }else if(aTob < bToa) {
                    nextGift[j]++;
                }else {
                    if(point[i] > point[j]) {
                        nextGift[i]++;
                    }else if(point[i] < point[j]){
                        nextGift[j]++;
                    }
                }
            }
        }
        
        int max = 0;
        for(int count : nextGift) {
            max = Math.max(max, count);
        }
        return max;
    }
}