package firststage.interfacedemo;

/**
 * 接口的应用 --工厂设计模式
 * 判断代码好坏标准
 * 1、客户端调用简单 不需要关注具体的细节
 * 2、客户端之外的代码修改 不影响用户的使用 用户不用去关心代码是否变更
 * 整个代码中我们最关心的是如何获取一个Fruit接口对象 而对象是被谁实例化的那不是客户端的工作 所以
 * 最大的问题就在于关键子new 这一问题就可以理解问耦合度高 代码不方便维护 就是说A一定要与B绑定
 * 解决思路可以完全参考Java虚拟机的设计思想： 程序 -> JVM -> 适应不同的操作系统
 */
public class InterfaceTestThree {
    public static void main(String[] args){
        Fruit fruit = Factory.getInstance("orange");
        fruit.eat();
    }
}

interface Fruit{
    public void eat();
}

class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

/**
 * 增加一个过渡类
 */
class Factory{
    public static Fruit getInstance(String strInstanceName){
        if ("apple".equals(strInstanceName)){
            return new Apple();
        }
        else if ("orange".equals(strInstanceName)){
            return new Orange();
        }
        else {
            return null;
        }
    }
}