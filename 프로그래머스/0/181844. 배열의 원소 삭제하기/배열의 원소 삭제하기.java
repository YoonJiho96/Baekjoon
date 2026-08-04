import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : delete_list) {
            set.add(n);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : arr) {
            if(!set.contains(n)) list.add(n);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}