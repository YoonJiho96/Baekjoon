import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] plain = br.readLine().toCharArray();
        char[] key = br.readLine().toCharArray();
        for (int i = 0; i < plain.length; i++) {
            if (plain[i] == ' ') {
                sb.append(' ');
                continue;
            }
            int c = ((plain[i]) - (key[i % key.length]) + 26) % 26;
            c = c == 0 ? 26 : c;
            sb.append((char) (c + 'a' - 1));
        }
        System.out.println(sb);
    }
}