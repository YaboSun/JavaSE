package demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class TestBigDecimal {
    public static long multi (long a, long b) {
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        return bigDecimal.multiply(bigDecimal1).longValue();
    }

    public static BigInteger multi (String x , String y) {
        BigInteger bigInteger = new BigInteger(x);
        BigInteger bigInteger1 = new BigInteger(y);
        return bigInteger.multiply(bigInteger1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        long a = scanner.nextLong();
        long b = scanner.nextLong();
//        while (scanner.hasNextLong()){
            System.out.println(multi(a,b));
//        }*/
        String x = scanner.next();
        String y = scanner.next();
        System.out.println(multi(x,y));
    }
}
