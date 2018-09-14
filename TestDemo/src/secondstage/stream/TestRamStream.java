package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestRamStream {
    public static void main(String[] args) throws Exception {
        String string = "Hello World";
        //本次通过内存操作流实现转换 先将数据存放在内存中 再从内存中读取数据
        //将所有数据存放在内存中
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        //将所有字符从内存中取出
        OutputStream outputStream = new ByteArrayOutputStream();
        //读取每一个字节数据
        int temp = 0;
        //每次读取一个数据
        while ((temp = inputStream.read()) != -1) {
            //字节输出流
            outputStream.write(Character.toUpperCase(temp));
        }
        System.out.println(outputStream);
        inputStream.close();
        outputStream.close();
    }
}
