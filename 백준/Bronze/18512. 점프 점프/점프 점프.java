import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if ((x * i + p1) == (y * j + p2)) {
                    System.out.println((x * i + p1));
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}