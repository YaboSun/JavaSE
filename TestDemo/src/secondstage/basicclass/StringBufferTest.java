package basicclass;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello").append("World").append("!!!");
        change(stringBuffer); //引用传递
        System.out.println(stringBuffer);
    }
    public static void change(StringBuffer tmp){
        tmp.append("\n").append("hello");
    }
}

