import java.util.*;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : rsp.toCharArray()) {
            switch(c) {
                case '0'-> sb.append('5');
                case '2'-> sb.append('0');
                case '5'-> sb.append('2');
            }
        }
        
        return sb.toString();
    }
}