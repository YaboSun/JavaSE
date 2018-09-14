package extend;

/**
 * 主要测试方法的覆写
 * 子类覆写方法名相同 返回值类型相同 但是方法权限可以不同
 * 具体主要是子类的权限应该扩大父类的权限
 * 需要特别注意的是如果父类方法声明为private则这个方法对子类是不可见的，所以是没法
 */
public class ExtendTestTwo {
    public static void main(String[] args){
       B b = new B();
       b.fun();
       b.print();
    }
}

class A{
    public void fun(){
        System.out.println("B；类中的fun方法");
    }
    public void print(){
        System.out.println("111");
    }
}

class B extends A{
    public void fun(){
        System.out.println("sfjk");
    }

    public void print(){
        super.print();
        System.out.println("222");
    }
}

/**
 * 重载和覆写的区别
 * 英文：overloading override
 * 发生范围：发生在一个类里面  发生在继承关系中
 * 定义： 方法名称相同、参数的类型及个数相同 方法名称相同、参数的类型及个数相同，返回值类型相同
 * 权限：没有权限的限制 子类方法不能比父类方法的权限更严格
 */

