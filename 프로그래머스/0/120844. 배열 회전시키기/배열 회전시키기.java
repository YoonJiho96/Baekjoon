import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];

        for(int i=0; i<len; i++) {
            if(direction.equals("right")) {
                answer[(i+1)%len] = numbers[i];
            }else {
                answer[(i-1+len) % len] = numbers[i];
            }
        }
        return answer;
    }
}