import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        for (int i = 1; i <= input.length; i++) {
            sb.append(input[i - 1]);
            if (i % 10 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}