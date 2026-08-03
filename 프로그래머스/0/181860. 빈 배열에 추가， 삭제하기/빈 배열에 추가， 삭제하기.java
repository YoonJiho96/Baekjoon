import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<flag.length; i++) {
            boolean f = flag[i];
            if(f) {
                int count = arr[i] * 2;
                while(count-- > 0) {
                    list.add(arr[i]);
                }
            }else {
                int count = arr[i];
                while(count-- > 0) {
                    list.remove(list.size() - 1);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}