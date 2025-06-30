import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            list.add(new Node(num, gold, silver, bronze));
        }

        list.sort((a, b) -> {
            if (b.gold != a.gold) return b.gold - a.gold;
            if (b.silver != a.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0).num, rank);

        for (int i = 1; i < N; i++) {
            Node prev = list.get(i - 1);
            Node cur = list.get(i);

            if (cur.gold == prev.gold && cur.silver == prev.silver && cur.bronze == prev.bronze) {
                map.put(cur.num, rank);
            } else {
                rank = i + 1;
                map.put(cur.num, rank);
            }
        }

        System.out.println(map.get(K));
    }

    static class Node {
        int num;
        int gold;
        int silver;
        int bronze;

        public Node(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}