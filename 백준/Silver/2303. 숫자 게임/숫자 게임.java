import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int NUM = 5, PICK = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalMAX = 0;
        int user = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int[] arr = new int[NUM];
            MAX = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            comb(arr, 0, 0);
            if (totalMAX <= MAX) {
                totalMAX = MAX;
                user = i;
            }
        }

        System.out.println(user);
    }

    static int[] tgt = new int[PICK];
    static int MAX = 0;

    static void comb(int[] arr, int count, int start) {  // start 매개변수 추가
        if (count >= PICK) {
            MAX = Math.max(MAX, Arrays.stream(tgt).sum() % 10);
            return;
        }

        for (int i = start; i < NUM; i++) {
            tgt[count] = arr[i];
            comb(arr, count + 1, i + 1);     // 다음 숫자는 현재 선택한 i 다음부터
        }
    }
}