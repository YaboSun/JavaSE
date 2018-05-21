package firststage.innerclass;

/**
 * 在开发的过程中，内部类尽量少用，优先考虑的还是普通类
 * 内部类可以访问外部类的私有属性，反之外部类也可以通过内部类对象访问内部类的私有属性
 * 使用static定义内部类，那么这个内部类就变成了一个外部类中存在的static属性，相当于定义了一个外部类
 */
public class FirstTest {
    public static void main(String[] args){
        Outer.Inner inner = new Outer.Inner();
        inner.print();
    }
}

/**
 * 定义外部类
 */
class Outer{
    private static String strMessage = "Hello World!";
    static class Inner{
        public void print(){
            System.out.println(strMessage);
        }
    }

    public void fun(){
        new Inner().print();
    }
}

