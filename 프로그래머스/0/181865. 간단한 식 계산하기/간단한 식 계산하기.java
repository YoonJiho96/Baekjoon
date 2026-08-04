import java.util.*;

class Solution {
    public int solution(String binomial) {
        String[] spt = binomial.split(" ");
        int a = Integer.parseInt(spt[0]);
        int b = Integer.parseInt(spt[2]);
        
        String op = spt[1];
        
        if(op.equals("+")) return a + b;
        else if(op.equals("-")) return a - b;
        else if(op.equals("*")) return a * b;
        
        return 0;
    }
}