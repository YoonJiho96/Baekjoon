import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 분
        int m = sc.nextInt();   // 하한
        int M = sc.nextInt();   // 상한
        int T = sc.nextInt();   // 증가량
        int R = sc.nextInt();   // 감소량

        int count = 0;
        int time = 0;
        int x = m;

        if (x + T > M) {
            System.out.println(-1);
            return;
        }
        while (count < N) {
            if (x + T <= M) {
                x += T;
                count++;
            }else {
                x = Math.max(m, x - R);
            }
            time++;
        }
        System.out.println(time);
    }
}