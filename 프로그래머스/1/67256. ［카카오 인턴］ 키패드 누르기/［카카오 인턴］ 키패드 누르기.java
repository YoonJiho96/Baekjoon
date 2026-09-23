import java.util.*;

class Solution {
    static int[][] nums = {
        {3, 1},
        {0, 0},
        {0, 1},
        {0, 2},
        {1, 0},
        {1, 1},
        {1, 2},
        {2, 0},
        {2, 1},
        {2, 2}
    };
    
    static int[] start = {3, 0};
    static int[] sharp = {3, 2};
    
    public String solution(int[] numbers, String hand) {      
        int[] leftPos = start;
        int[] rightPos = sharp;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = nums[num];
            }else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = nums[num];
            }else {
                int[] cur = nums[num];
                int leftLen = getLen(cur, leftPos);
                int rightLen = getLen(cur, rightPos);
                
                if(leftLen == rightLen) {
                    if(hand.equals("right")){
                        sb.append("R");
                        rightPos = cur;
                    }else {
                        sb.append("L");
                        leftPos = cur;
                    }
                }else if(leftLen < rightLen) {
                    sb.append("L");
                    leftPos = cur;
                }else {
                    sb.append("R");
                    rightPos = cur;
                }
            }
        }
        
        return sb.toString();
    }
    
    static int getLen(int[] pos1, int[] pos2) {
        return (Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
    }
}