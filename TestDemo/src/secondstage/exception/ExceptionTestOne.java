package exception;

/**
 * todo 异常的产生
 * 一旦产生异常之后 异常以及产生异常的语句将不再执行
 * 要做的是即使出现异常也要让程序正确的执行完毕
 * TODO 处理异常
 * 进行异常的处理 Java中提供了三个关键字 try、catch、finally
 *
 */

public class ExceptionTestOne {
    public static void main(String[] args){
        try {
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("这是finally方法");
        }
        System.out.println("sfajfsjf ");
    }
}
