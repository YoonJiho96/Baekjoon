import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oct = br.readLine();
        StringBuilder sb = new StringBuilder();

        int firstDigit = oct.charAt(0) - '0';
        sb.append(Integer.toBinaryString(firstDigit));

        for (int i = 1; i < oct.length(); i++) {
            int d = oct.charAt(i) - '0';
            sb.append((d >> 2) & 1)
                    .append((d >> 1) & 1)
                    .append(d & 1);
        }
        System.out.println(sb);
    }
}