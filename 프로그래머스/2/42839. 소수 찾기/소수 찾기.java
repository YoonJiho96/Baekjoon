import java.util.*;

class Solution {
    static int[] nums;
    static boolean[] visit;
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {        
        char[] input = numbers.toCharArray();
        nums = new int[numbers.length()];
        visit = new boolean[numbers.length()];
        
        for(int i=0; i<nums.length; i++) {
            nums[i] = input[i] - '0';
        }

        dfs(0);
        
        return set.size();
    }
    
    void dfs(int num) {
        if(num > 0) {
            System.out.println(num);
            if(isPrime(num))
                set.add(num);
        }
        
        for(int i=0; i<nums.length; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(num * 10 + nums[i]);
            visit[i] = false;
        }
    }
    
    
    
    boolean isPrime(int num){
        if(num <= 1) 
            return false;
        
        for(int i=2; i*i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}