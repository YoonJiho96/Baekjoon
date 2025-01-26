import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : s1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        HashSet<Character> chars = new HashSet<>();
        chars.addAll(map1.keySet());
        chars.addAll(map2.keySet());

        for (char c : chars) {
            int count1 = map1.getOrDefault(c, 0);
            int count2 = map2.getOrDefault(c, 0);
            result += Math.abs(count1 - count2);
        }
        System.out.println(result);
    }
}