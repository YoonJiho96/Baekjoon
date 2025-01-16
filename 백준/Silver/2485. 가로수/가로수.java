import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = arr[1] - arr[0];
        for (int i = 1; i < (N - 1); i++) {
            int n = arr[i + 1] - arr[i];
            gcd = gcd(gcd, n);
        }

        int sum = 0;
        for (int i = 0; i < (N - 1); i++) {
            int g = arr[i + 1] - arr[i];
            sum += (g / gcd) - 1;
        }
        System.out.println(sum);
    }

    static int gcd(int a, int b) {
        int n;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}