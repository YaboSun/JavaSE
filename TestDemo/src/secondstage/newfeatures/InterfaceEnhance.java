package newfeatures;

/**
 * 原本Java中只能有全局静态常量以及抽象方法
 * 但是jdk8
 */
public class InterfaceEnhance {
    public static void main(String[] args) {
        IMessage message = new MessageImpl();
        message.fun();
        IMessage.get();
    }
}
interface IMessage{
    public void print();
    default void fun(){
        System.out.println("毁三观的方法出现了！！！！");
    }
    static void get(){
        System.out.println("直接由接口调用");
    }
}
class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("Hello World");
    }

}