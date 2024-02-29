import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, map[][], srcIdx, min;
    static People people[];
    static int stair[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            people = new People[N * N];

            int idx = 0;
            srcIdx = 0;
            stair = new int[2][3];  // y, x, time
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 사람
                    if (map[i][j] == 1) {
                        people[srcIdx++] = new People(i, j);
                    }

                    // 계단
                    if (map[i][j] >= 2) {
                        stair[idx][0] = i;
                        stair[idx][1] = j;
                        stair[idx++][2] = map[i][j];
                    }
                }
            }

            min = Integer.MAX_VALUE;
            powerset(0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void powerset(int tgtIdx) {
        if (tgtIdx == srcIdx) {
            int max = 0;
            for (int i = 0; i < 2; i++) {
                PriorityQueue<People> pqueue = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);

                int time[] = new int[100];
                for (int j = 0; j < srcIdx; j++) {
                    if (people[j].target == i) {
                        pqueue.add(people[j]);
                    }
                }

                int end = 0;
                while (!pqueue.isEmpty()) {
                    People cur = pqueue.poll();
                    int start = cur.dis;
                    end = start + stair[cur.target][2];
                    for (int j = start; j < end; j++) {
                        if (time[j] == 3) {
                            end++;
                            continue;
                        }
                        time[j]++;
                    }
                    if (max < end) {
                        max = end;
                    }
                }
            }
            if (min > max) {
                min = max;
            }
            return;
        }

        people[tgtIdx].dis = Math.abs(people[tgtIdx].y - stair[0][0]) + Math.abs(people[tgtIdx].x - stair[0][1]) + 1;
        people[tgtIdx].target = 0;
        powerset(tgtIdx + 1);

        people[tgtIdx].dis = Math.abs(people[tgtIdx].y - stair[1][0]) + Math.abs(people[tgtIdx].x - stair[1][1]) + 1;
        people[tgtIdx].target = 1;
        powerset(tgtIdx + 1);
    }

    static class People {
        int y;
        int x;
        int dis;
        int target;

        public People(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}