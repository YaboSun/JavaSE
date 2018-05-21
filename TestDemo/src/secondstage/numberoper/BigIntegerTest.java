package numberoper;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) throws Exception {
        BigInteger bigInteger1 = new BigInteger("32454145345345345234");
        BigInteger bigInteger2 = new BigInteger("32454145345345345236");

        System.out.println(bigInteger1.add(bigInteger2));

    }
}
