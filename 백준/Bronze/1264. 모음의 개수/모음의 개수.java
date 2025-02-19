import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    static char[] moeum = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine().toLowerCase(Locale.ROOT);
            if (str.equals("#")) break;

            int sum = 0;
            for (char c : str.toCharArray()) {
                for (char ch : moeum) {
                    if (c == ch) {
                        sum++;
                        break;
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}