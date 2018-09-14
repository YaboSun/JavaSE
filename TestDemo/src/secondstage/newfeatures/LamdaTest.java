package newfeatures;

public class LamdaTest {
    public static void main(String[] args) {
/*        fun(new IMessageNew() {
            @Override
            public void printNew() {
                System.out.println("hello world");
            }
        });*/
        fun((x,y)-> x + y);
    }
    public static void fun(IMessageNew iMessage){
        System.out.println(iMessage.add(20,0));
    }
}

interface IMessageNew{
    //public  void printNew(String string);
    public int add(int x,int y);
}