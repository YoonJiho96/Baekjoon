import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        int N = Integer.parseInt(br.readLine());
        int count = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (count == n) {
                count++;
                while (!stack.isEmpty() && stack.peek() == count) {
                    stack.pop();
                    count++;
                }
            } else {
                stack.push(n);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() == count) {
                count++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}