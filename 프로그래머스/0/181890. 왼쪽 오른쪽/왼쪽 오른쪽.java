import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {     
        for(int i=0; i<str_list.length; i++) {
            String s = str_list[i];
            
            if(s.equals("l")) {
                return Arrays.copyOf(str_list, i);
            }else if (s.equals("r")) {
                return Arrays.copyOfRange(str_list, i+1, str_list.length);
            }
        }
        return new String[]{};
    }
}