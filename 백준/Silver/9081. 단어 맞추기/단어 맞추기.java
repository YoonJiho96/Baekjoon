import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line = br.readLine();
            char[] input = line.toCharArray();

            if (check(input)) {
                sb.append(new String(input)).append("\n");
            } else {
                sb.append(line).append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean check(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);

        int start = i + 1;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return true;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}