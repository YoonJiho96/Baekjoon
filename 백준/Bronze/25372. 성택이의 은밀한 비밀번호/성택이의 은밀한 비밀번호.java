import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            sb.append(s.length() >= 6 && s.length() <= 9 ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}