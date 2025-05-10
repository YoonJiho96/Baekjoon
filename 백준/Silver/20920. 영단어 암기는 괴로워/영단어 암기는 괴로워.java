import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Node> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            String input = br.readLine();

            if (input.length() < M) {
                continue;
            }

            if (map.containsKey(input)) {
                Node node = map.get(input);
                node.freq++;
                map.put(input, node);
            } else {
                map.put(input, new Node(1, input.length(), input));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node node : map.values()) {
            pq.offer(node);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            sb.append(node.str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static class Node implements Comparable<Node> {
        int freq;
        int len;
        String str;

        Node(int freq, int len, String str) {
            this.freq = freq;
            this.len = len;
            this.str = str;
        }

        @Override
        public int compareTo(Node n) {
            if (this.freq != n.freq) {
                return n.freq - this.freq;
            } else if (this.len != n.len) {
                return n.len - this.len;
            } else {
                return this.str.compareTo(n.str);
            }
        }
    }
}