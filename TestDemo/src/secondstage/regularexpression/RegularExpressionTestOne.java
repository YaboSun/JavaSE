package regularexpression;

public class RegularExpressionTestOne {
    public static void main(String[] args) {
        String string = "123";
        System.out.println(string.matches("[^axcbef]"));
        System.out.println(string.matches("[a-zA-Z]"));
        System.out.println(string.matches("[A-Z]"));
        System.out.println(string.matches("[0-9]"));
        System.out.println(string.matches("."));
        System.out.println(string.matches("\\d*"));
        System.out.println(string.matches("\\d{2,}"));
    }
}
