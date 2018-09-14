package map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> table = new Hashtable<>();
        map.put("一", 1);
        map.put("二", 2);
        map.put("三", 3);
        map.put("三", 33);
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(map);
        System.out.println(map.get("一"));
    }
}
