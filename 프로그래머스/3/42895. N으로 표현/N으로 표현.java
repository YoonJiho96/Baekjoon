import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) {
            return 1;
        }
        
        int answer = 0;
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i=0; i<=9; i++) {
            dp.add(new HashSet<Integer>());
        }
        
        dp.get(1).add(N);
        
        for(int i=2; i<=9; i++) {
            int listed = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(listed);
            
            for(int j=1; j<i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                
                for(int num1: set1) {
                    for(int num2: set2) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}