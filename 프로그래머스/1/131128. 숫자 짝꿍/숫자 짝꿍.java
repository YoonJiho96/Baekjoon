import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(char c : X.toCharArray()) {
            xArr[c - '0']++;
        }
        
        for(char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }

        int[] duo = new int[10];
        for(int i=0; i<10; i++) {
            if(xArr[i] > 0 && yArr[i] > 0) {
                duo[i] = Math.min(xArr[i], yArr[i]);                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            for(int j=0; j<duo[i]; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) {
            return "-1";
        }
        
        if(sb.toString().charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}