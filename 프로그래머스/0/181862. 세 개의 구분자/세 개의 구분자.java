import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        char[] str = myStr.toCharArray();
        
        ArrayList<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            if(c == 'a' || c == 'b' || c == 'c') {
                if(!sb.isEmpty()) {
                    list.add(sb.toString());
                    sb.setLength(0);    
                }
            }else {
                sb.append(c);
            }
        }
        
        if(!sb.isEmpty()) {
            list.add(sb.toString());
        }
        
        if(list.size() == 0) {
            list.add("EMPTY");
        }

        return list.toArray(new String[0]);
    }
}