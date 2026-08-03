import java.util.*;

class Solution {
    public int solution(int a, int b) {
        boolean aB = a % 2 == 0;
        boolean bB = b % 2 == 0;
        
        if(!aB && !bB) return a*a + b*b;
        else if(!aB || !bB) return 2 * (a + b);
        else if(aB && bB) return Math.abs(a - b);
        
        return 0;
    }
}