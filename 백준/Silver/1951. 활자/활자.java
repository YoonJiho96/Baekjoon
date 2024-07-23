import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        String num = String.valueOf(n);

        int size = num.length();
        int ans = 0;
        for (int i = 1; i < size; i++) {
            ans += (9 * Math.pow(10, i - 1) * i) % 1234567;
        }

        long tesm = (long) (size * (n - Math.pow(10, size - 1) + 1));
        System.out.println((ans + tesm) % 1234567);
    }
}
