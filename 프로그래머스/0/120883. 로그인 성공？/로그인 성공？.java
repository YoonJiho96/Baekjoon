import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        HashMap<String, String> map = new HashMap<>();
        for(String[] d : db) {
            map.put(d[0], d[1]);
        }
        
        String id = id_pw[0];
        String pw = id_pw[1];
        
        if(!map.containsKey(id)) {
            return "fail";
        }else {
            if(pw.equals(map.get(id))) {
                return "login";
            }else {
                return "wrong pw";
            }
        }
    }
}