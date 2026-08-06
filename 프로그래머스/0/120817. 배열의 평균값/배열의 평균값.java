import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        double answer = (double) Arrays.stream(numbers).sum() / (double) (numbers.length);
        
        return answer;
    }
}