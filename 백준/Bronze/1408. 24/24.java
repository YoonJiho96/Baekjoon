import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int A = a[0] * 3600 + a[1] * 60 + a[2];
        int B = b[0] * 3600 + b[1] * 60 + b[2];

        int C = B - A;
        if (C < 0) {
            C += 24 * 3600;
        }
        System.out.printf("%02d:%02d:%02d", C / 3600, C % 3600 / 60, C % 60);
    }
}