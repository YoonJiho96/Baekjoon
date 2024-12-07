import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minPq = new PriorityQueue<>();      // 작은 순
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());  // 큰 순
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int k = 0; k < K; k++) {
                String[] inputs = br.readLine().split(" ");
                int n = Integer.parseInt(inputs[1]);

                if (inputs[0].equals("I")) {
                    minPq.offer(n);
                    maxPq.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (n == 1) {
                        // 최대값 삭제
                        removeInvalid(maxPq, map);
                        if (!maxPq.isEmpty()) {
                            int max = maxPq.poll();
                            map.put(max, map.get(max) - 1);
                        }
                    } else {
                        // 최소값 삭제
                        removeInvalid(minPq, map);
                        if (!minPq.isEmpty()) {
                            int min = minPq.poll();
                            map.put(min, map.get(min) - 1);
                        }
                    }
                }
            }

            removeInvalid(minPq, map);
            removeInvalid(maxPq, map);

            if (minPq.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(maxPq.poll()).append(" ").append(minPq.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void removeInvalid(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map) {
        while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }
}