import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());   // 램프 수
        int G = Integer.parseInt(st.nextToken());   // 경비원 수
        int R = Integer.parseInt(st.nextToken());   // 라운드 수

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        boolean[] lamp = new boolean[L + 1];
        for (int i = 0; i < G; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String name = st2.nextToken();
            int a = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = a; j <= L; j += d) {
                list.add(j);
            }
            map.put(name, list);
        }

        for (int i = 0; i < R; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                for (int j : map.get(name)) {
                    lamp[j] = !lamp[j];
                }
            }
        }

        int sum = 0;
        for (boolean b : lamp) {
            sum += b ? 1 : 0;
        }
        System.out.println(sum);
    }
}