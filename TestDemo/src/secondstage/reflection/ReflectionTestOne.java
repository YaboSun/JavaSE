package reflection;


public class ReflectionTestOne {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("reflection.Student");
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    public Book(){
        System.out.println("********这是book的无参构造函数××××××××");
    }
    @Override
    public String toString() {
        return "这是一本书";
    }
}

class Student {
    public Student() {
        System.out.println("这是student的无参构造函数");

    }

    @Override
    public String toString() {
        return "Student{}";
    }
}