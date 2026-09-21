import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDay = toDay(today);
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] spt = term.split(" ");
            map.put(spt[0], Integer.parseInt(spt[1]) * 28);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<privacies.length; i++) {
            String[] spt = privacies[i].split(" ");
            int pDate = toDay(spt[0]);
            int term = map.get(spt[1]);
            
            if(pDate + term <= todayDay) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int toDay(String date) {
        String[] spt = date.split("\\.");
        int y = Integer.parseInt(spt[0]);
        int m = Integer.parseInt(spt[1]);
        int d = Integer.parseInt(spt[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}