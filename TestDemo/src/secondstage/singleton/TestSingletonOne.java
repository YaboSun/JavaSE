package singleton;

/**
 * 通过构造方法私有化
 * 分为饿汉式还有懒汉式
 *
 */
class Singleton{
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Singleton(){ //构造方法私有化

    }

    public void print(){
        System.out.println("hello world");
    }
}
public class TestSingletonOne {
    public static void main(String[] args){
        Singleton s = Singleton.getInstance();
        s.print();
    }
}
