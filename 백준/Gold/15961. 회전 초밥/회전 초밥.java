import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

  // N 접시 수

  // d 초밥 가짓수

  // k 연속해서 먹는 접시의 수

  // c 쿠폰 번호

  static int N, d, k, c;

  static int[] input, sushi;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    d = Integer.parseInt(st.nextToken());

    k = Integer.parseInt(st.nextToken());

    c = Integer.parseInt(st.nextToken());

    input = new int[N];

    sushi = new int[d + 1];

    for (int i = 0; i < N; i++) {

      input[i] = Integer.parseInt(br.readLine());

    }

    // 초기화

    for (int i = 0; i < k; i++) {

      sushi[input[i]]++;

    }

    int count = 0;

    int max = 0;

    for (int i = 1; i <= d; i++) {

      if (sushi[i] > 0) {

        count++;

      }

    }

    for (int i = 1; i < N; i++) {

      int start = i;

      int end = (i + k - 1) % N;

      sushi[input[start - 1]]--;

      if (sushi[input[start - 1]] == 0) count--;

      if (sushi[input[end]] == 0) count++;

      sushi[input[end]]++;

max = Math.max(max, count);

      if (sushi[c] == 0) {

        count++;

        max = Math.max(max, count);

        count--;

      }

    }

    System.out.println(max);

  }

}