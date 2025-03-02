import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] arr = new long[N + 1];
        arr[0] = 1;

        for (int i = 1; i <= N; i++) {
            long num = 0;
            for (int j = 0; j < i; j++) {
                num += arr[j] * arr[i - j - 1];
            }
            arr[i] = num;
        }
        System.out.println(arr[N]);
    }
}