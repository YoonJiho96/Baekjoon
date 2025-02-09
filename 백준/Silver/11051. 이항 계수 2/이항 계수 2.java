import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= Math.min(i, K); j++) {
                if (j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % 10007;
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}