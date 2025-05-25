import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append("*".repeat(i + 1)).append("\n");
        }
        for (int i = (N - 1); i > 0; i--) {
            sb.append("*".repeat(i)).append("\n");
        }
        System.out.println(sb);
    }
}