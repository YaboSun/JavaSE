package demo;

import java.util.Scanner;

public class TestAddDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer a = scanner.nextInt();
            Integer b = scanner.nextInt();
            System.out.println(a + b);
        }
    }
}
