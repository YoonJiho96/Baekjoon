import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            sb.append("Group ").append(count++).append("\n");

            List<String> names = new ArrayList<>();
            List<List<String>> msg = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                names.add(st.nextToken());

                while (st.hasMoreTokens()) {
                    msg.add(new ArrayList<>());
                    msg.get(i).add(st.nextToken());
                }
            }

            boolean find = false;
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num - 1; j++) {
                    if (msg.get(i).get(j).equals("N")) {
                        find = true;
                        sb.append(names.get((i - (j + 1) % num + num) % num)).append(" was nasty about ").append(names.get(i)).append("\n");
                    }
                }
            }
            if (!find) {
                sb.append("Nobody was nasty").append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}