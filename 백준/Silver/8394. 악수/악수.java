import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 1;
        int b = 2;

        if (N == 1) {
            System.out.println(a);
            return;
        }

        for (int i = 3; i <= N; i++) {
            int temp = (a + b) % 10;
            a = b;
            b = temp;
        }
        System.out.println(b);
    }
}