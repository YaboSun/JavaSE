package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        //设置了泛型 保证集合中所有的数据类型都一致
        List<String> all = new ArrayList<>(); //这里可以将arraylist换为vector结果一样
        System.out.println("长度： " + all.size() + "是否为空" + all.isEmpty());
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        System.out.println("长度： " + all.size() + "是否为空" + all.isEmpty());
        //collection接口定义了size（）方法可以取得集合长度
        //list子接口扩充了get方法 可以根据索引取得数据
        for (int i = 0; i < all.size(); i ++) {
            String s = all.get(i);
            System.out.println(s);
        }
    }
}
