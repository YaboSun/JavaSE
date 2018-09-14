package basicclass;

public class SystemTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String string = "";
        for (int i = 0; i < 3000; i++){
            string += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("开始时间：" + start);

        System.out.println("结束时间：" + end);
    }
}
