import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(char c : X.toCharArray()) {
            xArr[c - '0']++;
        }
        
        for(char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            int count = Math.min(xArr[i], yArr[i]);
            
            for(int j=0; j<count; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) {
            return "-1";
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}