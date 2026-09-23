import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<ArrayDeque<Integer>> list = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            list.add(new ArrayDeque<Integer>());
        }
        
        for(int i=0; i<board.length; i++) {
            int[] cur = board[i];
            for(int j=0; j<cur.length; j++) {
                if(cur[j] == 0) continue;
                list.get(j).addLast(cur[j]);
            }
        }
        
        ArrayDeque<Integer> bask = new ArrayDeque<>();
        for(int move : moves) {
            if(list.get(move - 1).size() == 0) continue;
            int num = list.get(move - 1).pollFirst();
            
            if(bask.size() == 0) {
                bask.addLast(num);
            }else if(bask.peekLast() == num) {
                bask.pollLast();
                answer += 2;
            }else {
                bask.addLast(num);
            }
        }
        return answer;
    }
}