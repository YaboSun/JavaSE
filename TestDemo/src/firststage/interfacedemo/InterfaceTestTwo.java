package firststage.interfacedemo;

/**
 * 主要学习接口的实际应用 --- 定义标准
 */
public class InterfaceTestTwo {
    public static void main(String[] args){
        Computer computer = new Computer();
        computer.plugin(new Flash());
    }
}

/**
 * 定义USB标准
 */
interface USB{
    public void start();
    public void stop();
}

/**
 * 定义电脑
 */
class Computer{
    //电脑的插入操作
    public void plugin(USB usb){
        usb.start();//固定操作
        usb.stop();
    }
}

/**
 * 定义U盘类
 */
class Flash implements USB{
    @Override
    public void stop() {
        System.out.println("U盘已拔出");
    }

    @Override
    public void start() {
        System.out.println("U盘开始使用");
    }
}

/**
 * 定义打印机类
 */
class Printer implements USB{
    @Override
    public void stop() {
        System.out.println("打印机停止使用");
    }

    @Override
    public void start() {
        System.out.println("打印机开始使用");
    }
}