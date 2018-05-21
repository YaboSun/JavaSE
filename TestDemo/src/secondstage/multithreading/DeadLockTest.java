package multithreading;

public class DeadLockTest {
    public static void main(String[] args) {

    }
}

class A {
    public synchronized void say(B b){
        System.out.println("给我本，我给你笔，否则不给");
    }

    public synchronized void get(){
        System.out.println("得到了本，付出了笔");
    }
}

class B {
    public synchronized void say(B b){
        System.out.println("给我笔，我给你本，否则不给");
    }

    public synchronized void get(){
        System.out.println("得到了本，付出了笔");
    }
}
