package interfacedemo;

/**
 * 接口的应用--编写一个简单的代理设计模式（proxy）
 */
public class InterfaceTestFour {
    public static void main(String[] args){
        Subject subject = new Proxy(new Major());
        subject.XXOO();
    }
}
/**
 * 定义一个核心接口主题
 */
interface Subject{
    public void XXOO();
}
/**
 * 定义一个准备类
 */
class Proxy implements Subject{
    private Subject subject;
    //要接收一个真实主题的操作对象
    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void prepare(){
        System.out.println("做准备工作");
    }
    @Override
    public void XXOO() {
        this.prepare();
        this.subject.XXOO(); //负责通知major可以执行了
        this.destory();
    }
    public void destory(){
        System.out.println("执行完所有工作的后续工作");
    }
}
/**
 * 定义一个主角色类
 */
class Major implements Subject{
    @Override
    public void XXOO() {
        System.out.println("正在XXOO");
    }
}