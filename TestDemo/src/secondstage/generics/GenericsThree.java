package generics;

public class GenericsThree {
    public static void main(String[] args) {
        String string = fun("hello");
        System.out.println(string);
    }
    public static <T> T fun(T t){
        return t;
    }
}

