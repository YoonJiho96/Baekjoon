import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        ArrayDeque<Character> op = new ArrayDeque<>();

        String temp = "";
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '+' || inputs[i] == '-') {
                int num = Integer.parseInt(temp);
                temp = "";
                nums.offer(num);
                op.offer(inputs[i]);
            } else {
                temp += inputs[i];
            }
        }
        nums.offer(Integer.parseInt(temp));

        int result = nums.poll();
        int minus = 0;
        while (!nums.isEmpty()) {
            int n = nums.poll();
            int o = op.poll();

            if (o == '-') {
                if (minus > 0) {
                    result -= minus;
                    minus = n;
                } else {
                    minus += n;
                }
            } else {
                if (minus > 0) {
                    minus += n;
                } else {
                    result += n;
                }
            }
        }
        System.out.println(result - minus);
    }
}