import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 2;
        for (int i = 0; i < 3; i++) {
            String temp = br.readLine();
            try {
                Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                continue;
            }
            num = Integer.parseInt(temp);
            num += (3 - i);
        }

        StringBuilder sb = new StringBuilder();
        if (num % 3 == 0) sb.append("Fizz");
        if (num % 5 == 0) sb.append("Buzz");
        if (sb.length() == 0) sb.append(num);

        System.out.println(sb);
    }
}
