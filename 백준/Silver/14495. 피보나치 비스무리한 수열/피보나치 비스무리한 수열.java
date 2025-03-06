import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        long[] arr = new long[N + 1];
        arr[1] = arr[2] = arr[3] = 1;

        for (int i = 4; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }
        System.out.println(arr[N]);
    }
}