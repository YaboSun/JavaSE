package reflection;

import java.util.Date;
import java.util.Locale;

public class ReflectionTestOne {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("reflection.Book");
            try {
                Object object = cls.newInstance();
                System.out.println(object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Book {
    public Book(){
        System.out.println("********这是book的无参构造函数××××××××");
    }
    @Override
    public String toString() {
        return "这是一本书";
    }
}