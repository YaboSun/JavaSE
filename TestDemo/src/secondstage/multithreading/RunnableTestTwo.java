package multithreading;

public class RunnableTestTwo {
    public static void main(String[] args) {
        MyRunnableTest myRunnableTest = new MyRunnableTest();
        new Thread(myRunnableTest,"自己的线程对象").start();
        myRunnableTest.run();
/*        new Thread(myRunnableTest).start();
        new Thread(myRunnableTest).start();*/
    }
}
class MyRunnableTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}