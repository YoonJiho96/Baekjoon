import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int resultY = 0;
        int resultX = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dis = getDis(a, b, y, x);
            
            min = Math.min(dis, min);
            if(dis == min) {
                resultY = a;
                resultX = b;
            }
        }
        System.out.println(resultY + " " + resultX);
    }

    static int getDis(int y, int x, int y2, int x2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }
}