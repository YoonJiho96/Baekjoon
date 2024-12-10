import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, d, k, c;
    static int[] sushi, info;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = inputs[0];  // 접시 수
        d = inputs[1];  // 초밥 가짓 수
        k = inputs[2];  // 연속 접시 수
        c = inputs[3];  // 쿠폰 초밥 번호

        sushi = new int[N];
        for (int n = 0; n < N; n++) {
            sushi[n] = Integer.parseInt(br.readLine());
        }

        info = new int[d + 1];
        int distinctCount = 0; // 현재 윈도우 내 초밥의 가짓수

        // 초기 윈도우 구성
        for (int i = 0; i < k; i++) {
            if (info[sushi[i]] == 0) distinctCount++;
            info[sushi[i]]++;
        }

        int max = distinctCount + (info[c] == 0 ? 1 : 0);;

        for (int start = 1; start < N; start++) {
            // 제거할 초밥
            int remove = sushi[start - 1];
            info[remove]--;
            if (info[remove] == 0) distinctCount--;

            // 추가할 초밥
            int end = (start + k - 1) % N;
            int add = sushi[end];
            if (info[add] == 0) distinctCount++;
            info[add]++;

            // 쿠폰 초밥 포함여부 체크
            int currentCount = distinctCount + (info[c] == 0 ? 1 : 0);
            max = Math.max(max, currentCount);
        }
        System.out.println(max);
    }
}