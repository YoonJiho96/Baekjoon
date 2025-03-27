import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            sb.append(s);
            if (s.charAt(s.length() - 1) != '.') {
                sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}