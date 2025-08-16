import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] bingo = new boolean[5][5];
    static HashMap<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.putIfAbsent(num, new int[]{i, j});
            }
        }

        int count = 1;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] pos = map.get(num);

                bingo[pos[0]][pos[1]] = true;
                if (countBingoLines() >= 3) {
                    System.out.println(count);
                    return;
                }
                count++;
            }
        }
    }

    static int countBingoLines() {
        int lines = 0;

        // rows
        for (int y = 0; y < 5; y++) {
            boolean ok = true;
            for (int x = 0; x < 5; x++) {
                if (!bingo[y][x]) {
                    ok = false;
                    break;
                }
            }
            if (ok) lines++;
        }

        // columns
        for (int x = 0; x < 5; x++) {
            boolean ok = true;
            for (int y = 0; y < 5; y++) {
                if (!bingo[y][x]) {
                    ok = false;
                    break;
                }
            }
            if (ok) lines++;
        }

        boolean diagonal = true;
        for (int i = 0; i < 5; i++) {
            if (!bingo[i][i]) {
                diagonal = false;
                break;
            }
        }
        if (diagonal) lines++;

        boolean diagonal2 = true;
        for (int i = 0; i < 5; i++) {
            if (!bingo[i][4 - i]) {
                diagonal2 = false;
                break;
            }
        }
        if (diagonal2) lines++;

        return lines;
    }
}