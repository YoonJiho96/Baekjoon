import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length;
        
        Arrays.sort(numbers);
        
        return numbers[len - 1] * numbers[len - 2];
    }
}