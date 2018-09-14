package multithreading;

public class RunnableTest {
    public static void main(String[] args) {
/*        MyRunnable runnableA = new MyRunnable("线程A");
        MyRunnable runnableB = new MyRunnable("线程B");
        MyRunnable runnableC = new MyRunnable("线程C");


        *//*runnableA.start();
        runnableB.start();
        runnableC.start();*//*

        new Thread(runnableA).start();
        new Thread(runnableB).start();
        new Thread(runnableC).start();*/

        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();

    }
}

class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name = name;
    }
    @Override          //覆写线程的run方法作为线程的主题操作方法
    public void run() {
        for (int i = 0; i < 200; i++){
            System.out.println(this.name + "-->" + i);
        }
    }
}

class Ticket implements Runnable {
    private int nTicket = 10;
    @Override
    public void run() {
        for (int i = 0;i < 100; i++){
            if (this.nTicket > 0){
                System.out.println("卖票，ticket = " + this.nTicket--);
            }
        }
    }
}