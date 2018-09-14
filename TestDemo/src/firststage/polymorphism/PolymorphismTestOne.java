package polymorphism;

/**
 * 多态：
 * 方法的多态性
 *    a、方法的重载
 *    b、方法的覆写
 * 对象的多态性：指的是发生在继承关系之中，子类和父类的转换问题
 *    a、向上转型（自动完成）：父类 父类对象 = 子类实例
 *    向上转型指的是可以统一类型,所有的父类发生了向上转型只能够看到父类有的函数列表，而不能够调用子类特有的方法
 *    b、向下转型（强制完成）：子类 子类对象 = （子类）父类实例
 *    向下转型指的是父类要调用子类特殊的方法
 *
 * 当需要参数统一 使用向上转型 又需要调用子类特殊方法，使用向下转型
 * 经验总结：
 * 80%情况下使用向上转型 因为可以得到参数的统一
 * 5%情况下使用向下转型 目的是调用子类的特殊方法
 * 15%情况不转型
 * 强制转型可能出现异常 就是ClassCastException
 * 对于向下转型发生之前 一定要首先发生对象的向上转型，建立关系以后才可以转型
 */
public class PolymorphismTestOne {
    public static void main(String[] args){
        A a = new A();
        A a1 = new B();//向上转型
        A a2 = new C();//向上转型
        a1.print();
        a2.print();

        B b =(B)a1; //向下转型
        System.out.println(a instanceof B);
        B b1 = (B) a;

        b1.print();
        b.print();
        b.fun();

    }
}
class A{
    public void print(){
        System.out.println("A、public void print()");
    }
}

class B extends A{
    public void print(){
        System.out.println("B、public void print()");
    }
    public void fun(){
        System.out.println("B、扩充的b的方法");
    }
}

class C extends A{
    public void print(){
        System.out.println("C、public void print()");
    }
}