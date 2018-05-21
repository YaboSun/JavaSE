package multithreading;

public class ThreadTestOne {
    public static void main(String[] args) {
        MyThread threadA = new MyThread("线程A");

        MyThread threadB = new MyThread("线程B");
        MyThread threadC = new MyThread("线程C");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name = name;
    }
    @Override          //覆写线程的run方法作为线程的主题操作方法
    public void run() {
        for (int i = 0; i < 200; i++){
            System.out.println(this.name + "-->" + i);
        }
    }
}
