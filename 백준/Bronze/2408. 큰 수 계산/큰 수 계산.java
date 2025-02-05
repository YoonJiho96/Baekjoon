import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        ArrayList<Object> tokens = new ArrayList<>();
        for (int i = 0; i < 2 * N - 1; i++) {
            String line = br.readLine().trim();
            if (i % 2 == 0) {
                tokens.add(new BigInteger(line));
            } else {
                tokens.add(line);
            }
        }

        ArrayList<Object> newTokens = new ArrayList<>();
        newTokens.add(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = (String) tokens.get(i);
            BigInteger num = (BigInteger) tokens.get(i + 1);
            if (op.equals("*")) {
                BigInteger last = (BigInteger) newTokens.remove(newTokens.size() - 1);
                newTokens.add(last.multiply(num));
            } else if (op.equals("/")) {
                BigInteger last = (BigInteger) newTokens.remove(newTokens.size() - 1);
                newTokens.add(floorDiv(last, num));
            } else {
                newTokens.add(op);
                newTokens.add(num);
            }
        }

        BigInteger result = (BigInteger) newTokens.get(0);
        for (int i = 1; i < newTokens.size(); i += 2) {
            String op = (String) newTokens.get(i);
            BigInteger num = (BigInteger) newTokens.get(i + 1);
            if (op.equals("+")) {
                result = result.add(num);
            } else {
                result = result.subtract(num);
            }
        }

        System.out.println(result.toString());
    }

    private static BigInteger floorDiv(BigInteger a, BigInteger b) {
        BigInteger q = a.divide(b);
        BigInteger r = a.remainder(b);
        if (!r.equals(BigInteger.ZERO) && a.signum() != b.signum()) {
            q = q.subtract(BigInteger.ONE);
        }
        return q;
    }
}