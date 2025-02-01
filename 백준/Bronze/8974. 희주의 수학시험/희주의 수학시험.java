import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(getSum(B) - getSum(A - 1));
    }

    static int getSum(int x) {
        int sum = 0;
        int count = 0;
        for (int i = 1; count < x; i++) {
            for (int j = 1; j <= i && count < x; j++) {
                sum += i;
                count++;
            }
        }
        return sum;
    }
}