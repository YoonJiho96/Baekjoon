import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(char c : picture[i].toCharArray()) {
                for(int j=0; j<k; j++) {
                    sb.append(c);
                }
            }
            
            for(int j=0; j<k; j++) {
                list.add(sb.toString());
            }
        }
        
        return list.toArray(new String[0]);
    }
}