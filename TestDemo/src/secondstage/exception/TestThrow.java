package exception;

class MyMath{
    public static int div(int x,int y) throws Exception{

        int result = 0;
        try {
            System.out.println("程序开始");
            result = x/y;
        }catch (Exception e){
            throw e;
        }finally {
            System.out.println("程序结束");
        }
        return result;
    }
}
public class TestThrow {
    public static void main(String[] args){
        try {
            System.out.println(MyMath.div(10,0));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
