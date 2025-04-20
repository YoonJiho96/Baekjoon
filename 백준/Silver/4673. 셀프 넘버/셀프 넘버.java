public class Main {
    static int[] arr = new int[10001];

    public static void main(String[] args) {

        for (int i = 1; i < arr.length; i++) {
            int result = getNumber(i);
            if (result < arr.length)
                arr[result] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int getNumber(int num) {
        int ans = num;

        while (num > 0) {
            int temp = num % 10;
            num = num / 10;
            ans += temp;
        }
        return ans;
    }
}