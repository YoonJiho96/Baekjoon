import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] arr = new int[201];        
        for(int[] line : lines) {
            for(int i=line[0]; i<line[1]; i++) {
                arr[i + 100]++;
            }
        }
        
        for(int a : arr) {
            if(a >= 2) answer++;
        }
        
        return answer;
    }
}