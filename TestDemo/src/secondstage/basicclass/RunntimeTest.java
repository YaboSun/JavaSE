package basicclass;

public class RunntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());

        String string = "";
        for (int i = 0; i < 2000; i++ ){

        }
    }
}
