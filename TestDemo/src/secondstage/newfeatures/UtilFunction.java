package newfeatures;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFunction {
    public static void main(String[] args) {
        /**
         * 定义功能型接口
         */
        Function<String,Boolean> function = "ssf##hello"::startsWith;
        System.out.println(function.apply("s"));
        /**
         * 消费型接口
         */
        Consumer<String> consumer = new Mydemo()::printdemo;
        consumer.accept("sfsf");
        /**
         * 供给型接口
         */
        Supplier<String> supplier = "hello"::toUpperCase;
        System.out.println(supplier.get());
        /**
         * 断言型接口
         */
        Predicate<String> predicate = "hello"::equalsIgnoreCase;
        System.out.println(predicate.test("hellO"));
    }
}
class Mydemo{
    public void printdemo(String string){
        System.out.println(string);
    }
}
