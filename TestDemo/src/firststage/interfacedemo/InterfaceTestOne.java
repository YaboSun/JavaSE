package interfacedemo;

/**
 * 主要学习接口的基本概念与主要特点 接口中只有抽象方法和全局常量
 * 接口的各个使用
 * 工厂设计模式 代理设计模式
 * 对于接口而言既可能实现接口 又可能实现继承 在都有的情况下先继承 再使用接口实现
 * 接口中只能使用一种访问权限 public
 * 一个抽象类可以继承一个抽象类 但是一个接口可以通过extends关键字继承多个接口 但是接口不能继承抽象类
 */
public class InterfaceTestOne {
    public static void main(String[] args){
        A a = new X();
        B b = (B)a;
        b.get();
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
    }
}

interface A{
    String NAME = "CUG";
    //void show();
    public static final String MSG = "Hello";
    public abstract void print();
    abstract class A1{
        public abstract void printInner();
    }
}

interface B{
    public abstract void get();
}

abstract class C{
    public abstract void change();
}
class X extends C implements A,B{
    @Override
    public void change() {
        System.out.println("继承c类的方法");
    }

    @Override
    public void print() {
        System.out.println("A接口的抽象方法");
    }

    @Override
    public void get() {
        System.out.println("B接口的抽象方法");
    }

    class X1 extends A1{
        @Override
        public void printInner() {

        }
    }
}

/**
 * 接口在实际开发之中的三大核心作用
 * 定义不同层之间的操作标准
 * 表示一种操作的能离
 * 表示将服务器段的远程方法师徒暴露给客户端
 */