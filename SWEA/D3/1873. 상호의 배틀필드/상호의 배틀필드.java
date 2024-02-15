import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, H, W, N;
    static char[][] map;
    static char[] input;
    // 상 하 좌 우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int tDir, curY, curX; // 상0하1좌2우3
    static char[] tank = { '^', 'v', '<', '>' };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 맵 초기화
            boolean found = false;
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                // 맵 초기화
                map[i] = br.readLine().toCharArray();

                // 탱크 좌표 초기화
                if (!found) {
                    for (int j = 0; j < W; j++) {
                        for (int k = 0; k < 4; k++) {
                            if (tank[k] == map[i][j]) {
                                curY = i;
                                curX = j;
                                tDir = k;
                                found = true;
                                break;
                            }
                        }
                        if (found)
                            break;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            input = br.readLine().toCharArray();

            for (char c : input) {
                switch (c) {
                    case 'U':
                        Move(0);
                        break;
                    case 'D':
                        Move(1);
                        break;
                    case 'L':
                        Move(2);
                        break;
                    case 'R':
                        Move(3);
                        break;
                    case 'S':
                        Shoot(tDir);
                        break;
                }
            }

            sb.append("#").append(t).append(" ");
            for(char[] c : map) {
                for(char c1 : c) {
                    sb.append(c1);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void Move(int dir) {
        // 방향 다음칸 체크
        int nY = curY + dy[dir];
        int nX = curX + dx[dir];
        tDir = dir;
        map[curY][curX] = tank[tDir];

        // 범위 내인지 검사
        if (nY < 0 || nY >= H || nX < 0 || nX >= W) {
            return;
        }
        // 이동할 수 있는 위치인지 검사
        char n = map[nY][nX];
        if (n == '*' || n == '#' || n == '-') {
            return;
        }
        // 이동
        map[nY][nX] = tank[dir]; // 이동
        map[curY][curX] = '.'; // 이전 땅

        curY = nY;
        curX = nX;
    }

    static void Shoot(int dir) {
        int nY = curY;
        int nX = curX;
        // 현재 방향 끝까지 쳌쳌
        while (true) {
            nY += dy[dir];
            nX += dx[dir];

            // 범위 내인지 검사
            if (nY < 0 || nY >= H || nX < 0 || nX >= W) {
                return;
            }

            // 부술 수 없는 벽 만남
            char n = map[nY][nX];
            if (n == '#') {
                return;
            }
            // 부술 수 있는 벽
            else if (n == '*') {
                map[nY][nX] = '.';
                return;
            }
        }
    }
}