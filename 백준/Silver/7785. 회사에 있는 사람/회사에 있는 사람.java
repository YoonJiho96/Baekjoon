import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter")) {
                set.add(name);
            } else if (cmd.equals("leave")) {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for (String name : list) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}