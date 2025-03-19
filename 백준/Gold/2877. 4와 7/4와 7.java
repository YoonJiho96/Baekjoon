import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 4;
        int b = 7;
        long K = Long.parseLong(br.readLine());
        
        // case1: 한 숫자가 0인 경우
        if (a == 0 || b == 0) {
            // nonzero digit를 d라 하자.
            int d = (a == 0 ? b : a);
            // 1자리 수의 경우에는 오직 d만 만들 수 있다.
            // 그 외 L자리 (L>=2) 수의 개수는 2^(L-1)개
            // 누적 개수: for L = 1, count = 1; for L>=2, 누적 = 1 + (2^(L-1)-1) = 2^(L-1)
            long cumulative = 1;  // L = 1: count 1
            int L = 1;
            while (cumulative < K) {
                L++;
                long countForL = 1L << (L - 1); // 2^(L-1)
                cumulative += countForL;
            }
            // L자리 수 그룹에 속함
            if (L == 1) { 
                // K==1인 경우
                System.out.println(d);
                return;
            }
            // 이전 그룹까지의 누적 개수는 2^(L-1) - 1 (L>=2인 경우)
            long prev = (1L << (L - 1)) - 1;
            long offset = K - prev; // L자리 그룹 내에서의 순서 (1-indexed)
            long index = offset - 1; // 0-indexed, 범위: 0 ~ 2^(L-1)-1
            
            // L자리 수: 첫 자리는 반드시 d, 그 뒤 L-1자리는 index의 이진 표현(길이 L-1)에서
            // 각 비트가 0이면 '0', 1이면 d로 매핑
            StringBuilder sb = new StringBuilder();
            sb.append(d); // 첫 자리는 d (nonzero)
            for (int i = L - 2; i >= 0; i--) {
                if (((index >> i) & 1) == 1)
                    sb.append(d);
                else
                    sb.append('0');
            }
            System.out.println(sb.toString());
            
        } else { 
            // case2: 두 숫자 모두 0이 아닌 경우
            // 두 숫자를 오름차순 정렬하여 d1, d2 (d1 < d2)라 하자.
            int d1 = Math.min(a, b);
            int d2 = Math.max(a, b);
            // L자리 수의 개수: 2^L개
            // 누적 개수 (L=1부터 L까지): 2^(L+1) - 2개
            long cumulative = (1L << (1 + 1)) - 2; // L=1일 때: 2^(2)-2 = 2
            int L = 1;
            while (cumulative < K) {
                L++;
                cumulative = (1L << (L + 1)) - 2;
            }
            // 이전 그룹까지 누적 개수: if L==1 then 0, else 2^(L) - 2
            long prev = (L == 1 ? 0 : ((1L << L) - 2));
            long offset = K - prev; // L자리 그룹 내에서의 순서 (1-indexed)
            long index = offset - 1; // 0-indexed, 범위: 0 ~ 2^L - 1
            
            // L자리 수는 index의 L자리 이진수와 일대일 대응된다.
            // 이진수의 각 비트가 0이면 d1, 1이면 d2로 매핑한다.
            StringBuilder sb = new StringBuilder();
            for (int i = L - 1; i >= 0; i--) {
                if (((index >> i) & 1) == 1)
                    sb.append(d2);
                else
                    sb.append(d1);
            }
            System.out.println(sb.toString());
        }
    }
}
