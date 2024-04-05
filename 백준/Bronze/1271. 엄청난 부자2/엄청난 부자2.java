import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();

        BigInteger moneyPerCreature = n.divide(m);
        BigInteger remainingMoney = n.mod(m);

        System.out.println(moneyPerCreature);
        System.out.println(remainingMoney);
	}
}