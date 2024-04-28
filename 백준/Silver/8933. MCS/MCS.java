import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Map<Character, Integer> map;
	static Map<Integer, Integer> resultMap;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			char[] input = st.nextToken().toCharArray();

			resultMap = new HashMap<>();

			map = new HashMap<>();
			map.put('A', 0);
			map.put('C', 0);
			map.put('G', 0);
			map.put('T', 0);

			for (int i = 0; i < w; i++) {
				map.put(input[i], map.get(input[i]) + 1);
			}
			String temp = toStr();
			int asd = temp.hashCode();
			resultMap.putIfAbsent(asd, 0);
			resultMap.put(asd, resultMap.get(asd) + 1);

			for (int i = w; i < input.length; i++) {
				map.put(input[i - w], map.get(input[i - w]) - 1);
				map.put(input[i], map.get(input[i]) + 1);

				temp = toStr();
				asd = temp.hashCode();
				resultMap.putIfAbsent(asd, 0);
				resultMap.put(asd, resultMap.get(asd) + 1);
			}
			int max = Collections.max(resultMap.values());
			sb.append(max).append("\n");
			System.gc();
		}
		System.out.println(sb);
	}

	public static int getIdx(char idx) {
		return idx == 'A' ? 0 : idx == 'C' ? 1 : idx == 'G' ? 2 : 3;
	}

	public static String toStr() {
		StringBuilder temp = new StringBuilder();
		temp.append('A').append(map.get('A')).append('C').append(map.get('C')).append('G').append(map.get('G'))
				.append('T').append(map.get('T'));
		return temp.toString();
	}
}