package list;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) throws Exception {
        Set<String> all = new HashSet<>();
        Set<String> all1 = new TreeSet<>();
        all.add("Hello");
        all.add("Hello");
        all.add("World");

        all1.add("x");
        all1.add("a");
        all1.add("c");
        all1.add("b");
        all1.add("x");


        System.out.println(all);
        System.out.println(all1);
    }
}
