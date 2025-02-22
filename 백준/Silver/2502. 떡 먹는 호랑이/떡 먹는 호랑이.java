import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int K = sc.nextInt();

        int a = 1, b = 1;
        for (int i = 3; i < D; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        
        for (int B = 1; B < K; B++) {
            int remaining = K - b * B;
            if (remaining <= 0) continue;
            if (remaining % a == 0) {
                int A = remaining / a;
                if (A <= B) {
                    System.out.println(A);
                    System.out.println(B);
                    return;
                }
            }
        }
    }
}