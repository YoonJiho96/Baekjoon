import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String N = br.readLine().trim();
            if (N.equals("0")) break;

            while (N.length() > 1) {
                int sum = 0;
                for (char c : N.toCharArray()) {
                    sum += c - '0';
                }
                N = String.valueOf(sum);
            }

            sb.append(N).append("\n");
        }
        System.out.println(sb);
    }
}