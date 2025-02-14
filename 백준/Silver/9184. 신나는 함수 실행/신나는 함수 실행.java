import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[][][] ws = new int[21][21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) {
                        ws[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        ws[i][j][k] = ws[i][j][k - 1] + ws[i][j - 1][k - 1] - ws[i][j - 1][k];
                    } else {
                        ws[i][j][k] = ws[i - 1][j][k]
                                + ws[i - 1][j - 1][k]
                                + ws[i - 1][j][k - 1]
                                - ws[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            if (a <= 0 || b <= 0 || c <= 0) {
                sb.append(ws[0][0][0]).append("\n");
            } else if (a > 20 || b > 20 || c > 20) {
                sb.append(ws[20][20][20]).append("\n");
            } else {
                sb.append(ws[a][b][c]).append("\n");
            }
        }

        out.print(sb);
        out.flush();
        out.close();
    }
}