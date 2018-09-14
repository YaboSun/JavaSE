package multithreading;

public class SynchonizedTest {
    public static void main(String[] args) {

    }
}

class MySynchonized implements Runnable {
    private int nTicket = 5;
        @Override
        public void run () {
            for (int i = 0; i < 20; i++){
                synchronized (this) { //指的是当前操作每次只允许一个进程对象进入
                    if (this.nTicket > 0){
                        try {
                            Thread.sleep(100);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "卖票,ticket");
                    }
                }
            }

        }
}