package innerclass;

/**
 * 在方法中定义内部类
 */
public class SecondTest {
    public static void main(String[] args){
        new OuterClass().fun();
    }
}
class OuterClass{
    private String strMessage = "Hello World";
    public void fun(){
        class Inner{
            public void print(){
                System.out.println(strMessage);
            }
        }
        new Inner().print();
    }
}
