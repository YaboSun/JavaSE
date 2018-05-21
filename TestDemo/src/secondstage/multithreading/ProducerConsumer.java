package multithreading;

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        Info info = new Info();
        new Thread(new Productor(info)).start();
        new Thread(new Consumer(info)).start();
    }
}

class Info {
    private String title;
    private String content;
    //flag = true表示可以生产但是不可以取走，反之可以取走但是不可以生产
    private boolean flag = true;

    public synchronized void set(String title,String content)  {
        //重复进入set（）方法中发现不能够生产需要等待
        if (!this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.content  = content;
        this.flag = false;//修改生产标记
        super.notify();
    }
    public synchronized void get(){
        if (this.flag){  //还没生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.title + "-" + this.content);
        this.flag = true;
        super.notify();
    }
    public String getContent() {
        return content;
    }

    public String getTitle() {

        return title;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
class Productor implements Runnable {
    private Info info;
    public Productor (Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                this.info.set("Java","是门好语言");
            }
            else {
                this.info.set("我爱","学习Java");
            }
        }
    }
}

class Consumer implements Runnable {
    private Info info;
    public Consumer(Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            this.info.get();
        }
    }
}

