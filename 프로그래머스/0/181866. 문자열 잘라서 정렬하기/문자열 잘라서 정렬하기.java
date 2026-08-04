import java.util.*;

class Solution {
    public String[] solution(String myString) {
        StringTokenizer st = new StringTokenizer(myString, "x");
        ArrayList<String> list = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}