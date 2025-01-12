import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    sb.append(s[k]);
                }
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}