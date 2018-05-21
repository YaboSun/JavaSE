package reflection;

import java.lang.reflect.Field;
import java.util.Locale;

public class ReflectionTestThree {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("fortest.Book");
        Object object = cls.newInstance();
        Field titleField = cls.getDeclaredField("title");
        titleField.setAccessible(true);
        titleField.set(object,"java开发");
        System.out.println(titleField.get(object));

    }
}
