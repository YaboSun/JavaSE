package stream;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamNewDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("Hello");
        all.add("Android");
        all.add("javajsp");
        all.add("jsp");
        all.add("Oracle");
        all.add("Hello");
        // 测试forEach使用
        all.forEach(System.out::println);
        // 测试stream
        Stream<String> stream = all.stream();
//      System.out.println(stream.count());
        // 利用stream功能取消重复数据
        //System.out.println(stream.distinct().collect(Collectors.toList()));
        /**
         * 测试过滤,增加了filter，使用了断言型的函数式接口，使用string类中的contains方法
         * 但是这个时候显示的是区分大小写的过滤
         * 这个时候可以在过滤之前对数据做统一的处理 例如转大写或转小写
         */
        /*List<String> newAll = stream.distinct().map((x) -> x.toLowerCase())
                .filter((x) -> x.contains("a"))
                .collect(Collectors.toList());
        System.out.println(newAll);*/
        /**
         * 测试实现数据的匹配操作
         * 单个匹配
         */
        /*if (stream.anyMatch((x) -> x.contains("jsp"))) {
            System.out.println("数据存在");
        }*/
        /**
         * 测试多个条件引用
         */
        Predicate<String> p1 = (x) -> x.contains("jsp");
        Predicate<String> p2 = (x) -> x.contains("java");
        if (stream.anyMatch(p1.and(p2))) {
            System.out.println("数据存在！");
        }
        else {
            System.out.println("数据不存在！");
        }
    }
}
