import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger[] arr = new BigInteger[10001];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.valueOf(1);

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        System.out.println(arr[n]);
    }
}