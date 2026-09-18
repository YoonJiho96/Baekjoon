import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int num = id_list.length;
        for(int i=0; i<num; i++) {
            map.put(id_list[i], i);
        }
        
        boolean[][] users = new boolean[num][num];
        for(String r : report) {
            String[] spt = r.split(" ");
            String from = spt[0];
            String to = spt[1];
            
            users[map.get(from)][map.get(to)] = true;
        }
        
        int[] result = new int[num];
        for(int i=0; i<num; i++) {
            boolean[] user = users[i];
            for(int j=0; j<num; j++) {
                if(user[j]) {
                    result[j]++;
                }
            }
        }
        
        int[] answer = new int[num];
        for(int i=0; i<num; i++) {
            boolean[] user = users[i];
            for(int j=0; j<user.length; j++) {
                if(user[j] && result[j] >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}