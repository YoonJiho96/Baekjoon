import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int[] cmd : commands) {
            int start = cmd[0];
            int end = cmd[1];
            int idx = cmd[2];
            
            int[] temp = new int[end - start + 1];
            int count = 0;
            for(int i=start-1; i<end; i++) {
                temp[count++] = array[i];
            }
            
            Arrays.sort(temp);
            list.add(temp[idx - 1]);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}