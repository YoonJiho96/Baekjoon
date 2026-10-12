import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<answer.length; i++) {
            int[] cmd = commands[i];
            int[] temp = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            
            Arrays.sort(temp);
            answer[i] = temp[cmd[2] - 1];
        }
        return answer;
    }
}