package firststage.abstractdemo;

/**
 * 拥有抽象方法的类一定属于抽象类 抽象类要使用abstract声明
 * 抽象类必须有子类 每一个抽象类一定要被子类所继承
 * 抽象类的子类（子类不是抽象类）必须覆写抽象类之中的全部抽象方法（强制子类覆写）
 * 抽象类的对象实例化需要依靠子类完成 采用向上转型的方式处理
 * 抽象类里面由于会有一些属性 那么一定会存在构造方法 为类实例化属性 实例化的时候依然先执行父类构造再调用子类构造
 * 抽象类不能使用final继承
 * 外部抽象类不允许使用static修饰 而内部类可以使用 使用static声明的内部类相当于一个外部抽象类 继承的时候使用“外部类.内部类”的形式表示类名称
 * 任何情况下 如果要执行类中的static方法的时候都可以在没有对象的时候直接调用 对于抽象类也一样
 */
public class AbstractTestOne {
    public static void main(String[] args){
        A a = new B();
        a.print();
        A.InnerB innerB = new C();
        innerB.paint();
        A.prints();
        A.getInstance().print();
    }
}

/**
 * 定义一个抽象类
 */
abstract class A{
    static abstract class InnerB{
        public abstract void paint();
    }
    public void fun(){
        System.out.println("存在有方法体的方法！");
    }

    //定义一个static方法
    public static void prints(){
        System.out.println("Hello static");
    }
    //定义一个内部抽象类子类
    private class X extends A{
        @Override
        public void print() {
            System.out.println("这是一个内部抽象类子类");
        }
    }

    public static A getInstance(){
        return new B();
    }
    //定义一个抽象方法的声明 由abstract修饰 并且没有方法体的声明
    public abstract void print();
}

/**
 * 定义抽象类的子类 一个子类只能继承一个抽象类
 */
class B extends A{
    @Override
    public void fun() {
        super.fun();
    }

    @Override
    public void print() {
        System.out.println("Hello World");
    }
}

class C extends A.InnerB{
    @Override
    public void paint() {
        System.out.println("hhhhhh");
    }
}