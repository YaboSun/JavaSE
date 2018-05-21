package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("一", 1);
        map.put("二", 2);
        map.put("三", 3);
        map.put("三", 33);
        //将map集合变为iterator集合 目的是使用iterator进行输出
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator  = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> me = iterator.next();
            System.out.println(me.getKey() + me.getValue());
        }
    }
}
