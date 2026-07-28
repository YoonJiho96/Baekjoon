import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(char c : br.readLine().toCharArray()) {
            if(Character.isLowerCase(c)) c = Character.toUpperCase(c);
            else c = Character.toLowerCase(c);
            sb.append((char)(c));
        }
        System.out.println(sb.toString());
    }
}