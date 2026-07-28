import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(char c : br.readLine().toCharArray()) {
            sb.append(c).append("\n");
        }
        System.out.println(sb.toString());
    }
}