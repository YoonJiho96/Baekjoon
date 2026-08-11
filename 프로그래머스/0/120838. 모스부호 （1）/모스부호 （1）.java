import java.util.*;

class Solution {
    public String solution(String letter) {
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashMap<String, Character> map = new HashMap<>();
        for(int i=0; i<mos.length; i++){
            map.put(mos[i], (char)('a' + i));
        }
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(letter);
        while(st.hasMoreTokens()) {
            sb.append(map.get(st.nextToken()));
        }
        
        return sb.toString();
    }
}