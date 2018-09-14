package anonymousInnerclass;

public class TestOne {
    public static void main(String[] args){
        fun(new Message(){
            @Override
            public void print() {
                System.out.println("hello world");
            }
        });
    }
    public static void fun(Message message){
        message.print();
    }
}

interface Message{
    public void print();
}
