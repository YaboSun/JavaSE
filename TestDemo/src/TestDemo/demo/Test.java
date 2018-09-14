package demo;
import java.lang.reflect.Method;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        // 反射的测试
/*        Class<?> cls = Class.forName("demo.TestDemo");
        Method replaceMethod = cls.getDeclaredMethod("replaceSpace", StringBuffer.class);
        System.out.println(replaceMethod.invoke(cls.newInstance(),new StringBuffer("sfs")));*/


        // 集合的相关操作实现
/*        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println(string);
        }*/


        /**
         * map接口的操作
         */

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("三", 3);
        map.put("二", 2);
        map.put("一", 1);
        map.put("四", 4);
        map.put("二", 22);
        map.put(null, 3);

        // 使用iterator进行输出的步骤
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> stringIterator = entrySet.iterator();
        while (stringIterator.hasNext()) {
            Map.Entry<String, Integer> me = stringIterator.next();
            System.out.println(me.getKey());
            //System.out.println(stringIterator.next());
        }

        // 一般输出的步骤
/*        Set<String> stringSet = map.keySet();
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(stringSet);
        System.out.println(map.get("三"));
        System.out.println(map.get(null));
        System.out.println(map);*/
    }
}
