import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int gap = 1;
        
        if(n == 1) a = 0;
        else if(n == 2) b = num_list.length - 1;
        else if(n == 4) gap = c;
        
        int[] arr = new int[num_list.length];
        
        int idx = 0;
        for(int i=a; i<=b; i+=gap) {
            arr[idx++] = num_list[i];
        }
        
        return Arrays.copyOf(arr, idx);
    }
}