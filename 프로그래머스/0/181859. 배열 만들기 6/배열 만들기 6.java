import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int idx=0;
        for(int n : arr) {
            if(idx == 0) {
                stk[idx++] = n;
            }else {
                if(stk[idx - 1] == n) {
                    stk[--idx] = 0;
                }else {
                    stk[idx++] = n;
                }
            }
        }
        int[] result = Arrays.copyOf(stk,idx);
        return result.length !=0? result:new int[]{-1};
    }
}