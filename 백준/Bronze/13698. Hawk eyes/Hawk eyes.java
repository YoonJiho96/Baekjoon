import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int[] balls = new int[4];
        balls[0] = 1;
        balls[3] = 2;

        for (char c : arr) {
            if (c == 'A') {
                int temp = balls[0];
                balls[0] = balls[1];
                balls[1] = temp;
            } else if (c == 'B') {
                int temp = balls[0];
                balls[0] = balls[2];
                balls[2] = temp;
            } else if (c == 'C') {
                int temp = balls[0];
                balls[0] = balls[3];
                balls[3] = temp;
            } else if (c == 'D') {
                int temp = balls[1];
                balls[1] = balls[2];
                balls[2] = temp;
            } else if (c == 'E') {
                int temp = balls[1];
                balls[1] = balls[3];
                balls[3] = temp;
            } else if (c == 'F') {
                int temp = balls[2];
                balls[2] = balls[3];
                balls[3] = temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (balls[i] == 1) {
                System.out.println(i + 1);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (balls[i] == 2) {
                System.out.println(i + 1);
            }
        }
    }
}