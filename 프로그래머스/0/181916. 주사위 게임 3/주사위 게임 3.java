import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] count = new int[7];
        count[a]++;
        count[b]++;
        count[c]++;
        count[d]++;
        
        int p = 0;
        int q = 0;
        int r = 0;
        
        boolean isTwoPair = false;
        
        for(int i=1; i<=6; i++) {
            if(count[i] == 4) {
                return 1111 * i;
            } else if(count[i] == 3) {
                p = i;
            } else if(count[i] == 2) {
                if(p != 0) {
                    q = i;
                    isTwoPair = true;
                } else {
                    p = i;
                }
            } else if(count[i] == 1) {
                if(q == 0) {
                    q = i;
                } else {
                    r = i;
                }
            }
        }
        
        if(count[p] == 3) {
            return (10 * p + q) * (10 * p + q);
        } else if(isTwoPair) {
            return (p + q) * Math.abs(p - q);            
        } else if(p != 0) {
            return q * r;
        } else {
            for(int i=1; i<=6; i++) {
                if(count[i] == 1) {
                    return i;
                }
            }
        }
        
        return 0;
    }
}