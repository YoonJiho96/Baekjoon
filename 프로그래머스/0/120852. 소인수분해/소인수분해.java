import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        int num = 2;
        while(n > 1) {
            int mod = n % num;
            if(mod == 0){
                n = n / num;
                set.add(num);
            }else {
                num++;
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int s : set) {
            answer[idx++] = s;
        }
        Arrays.sort(answer);
        return answer;
    }
}