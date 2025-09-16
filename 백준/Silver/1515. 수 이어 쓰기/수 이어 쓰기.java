import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int startIdx = 0;
        int n = 0;

        while (true) {
            n++;
            String cur = String.valueOf(n);

            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == s.charAt(startIdx)) {
                    startIdx++;
                }

                if (startIdx == s.length()) {
                    System.out.println(n);
                    return;
                }
            }
        }
    }
}