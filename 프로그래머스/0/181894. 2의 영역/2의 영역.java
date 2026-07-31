import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int left = -1;
        int right = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                left = i;
                break;
            }
        }
        
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] == 2) {
                right = i;
                break;
            }
        }
        
        if(left == -1) {
            return new int[]{-1};
        }
        
        return Arrays.copyOfRange(arr, left, right + 1);
    }
}