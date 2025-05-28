import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 입구에서의 순서를 저장
        HashMap<String, Integer> map = new HashMap<>();
        String[] exitCars = new String[N];

        // 입구 순서 저장
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            map.put(car, i);
        }

        // 출구 순서 저장
        for (int i = 0; i < N; i++) {
            exitCars[i] = br.readLine();
        }

        int result = 0;
        // 각 차량에 대해 추월 여부 확인
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // 현재 차의 입구 순서
                int car1Entry = map.get(exitCars[i]);
                // 비교할 차의 입구 순서
                int car2Entry = map.get(exitCars[j]);
                
                // 원래 뒤에 있던 차가 앞에 있는 경우 추월한 것
                if (car1Entry > car2Entry) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}